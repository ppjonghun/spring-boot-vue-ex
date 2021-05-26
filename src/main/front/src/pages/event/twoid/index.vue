<template>
    <div class="card" >
        <div class="card-header">
            <b-button variant="primary" @click="createTwoidEvent()">등록</b-button>
        </div>
        <div class="card-body">
            <b-table :hover="hover" :fields="fields" :items="items">
                <template #cell(action)="{item}">
                    <b-button variant="danger" @click="updateTwoidEvent(item)">
                    수정
                    </b-button>
                </template>
            </b-table>
            <b-pagination
                v-model="currentPage"
                :total-rows="tableRows"
                :per-page="perPage"
                aria-controls="my-table"
                :align="'center'"
                @change="clickPage"
            ></b-pagination>
        </div>
        <modal-twoid-event
            :selected-twoid-event="selectedTwoidEvent"
            :modalState="modalState"/>
    </div>
</template>



<script>
import ModalTwoidEvent from '../../../components/pages/event/twoid/ModalTwoidEvent.vue';

export default {
    name : 'index',
    components:{ModalTwoidEvent},

    data() {
      return {
        fields: [
          { key: 'index', label: 'index' },
          { key: 'eventNm', label: '이벤트명'},
          { key: 'startDt', label: '시작일', formatter: (value) => this.convertDate(value) },
          { key: 'endDt', label: '종료일', formatter: (value) => this.convertDate(value)},
          { key: 'createDt', label: '등록일', formatter: (value) => this.convertDate(value)},
          { key: 'statusCd', label: '상태', formatter: (value) => this.convertStatusCd(value)},
          { key: 'action', label: '수정'},

        ],
        items: [],
        perPage: 10,
        currentPage: 1,
        tableRows : 0,
        modalState: '',
        selectedTwoidEvent :{},
        hover: true,
      }
    },
    beforeMount(){
        this.getOEList();
    },

    methods:{
        async getOEList(page){
            const params = {};
            this.setPagingInfo(params, page);
            try{
                const data = await this.$axios({
                    method : 'post',
                    url : APP_LOCAL_API_URL + '/twoidEvent/selectTwoidEventList',
                    data : params
                });

                this.items = data.data.data;
                this.tableRows = this.items.length && this.items[0].totalCount;

                this.setIndexTo(this.items);
                //console.log(data.data.comment);
            }catch(e){
                console.log(e.message);
            }
        },

        setPagingInfo(params, page){
            this.currentPage = typeof page === 'object' || !page ? 1 : page;
            params.offset = (this.currentPage -1) * this.perPage;
            params.limit = this.perPage;
        },

        async clickPage(page){
            await this.getOEList(page);
        },

        async updateTwoidEvent(item){
            this.modalState = 'UPDATE';

            this.selectedTwoidEvent = item;
            this.$bvModal.show('modal_twoid_event');
        },

        async createTwoidEvent(){
            this.modalState = 'CREATE';

            this.$bvModal.show('modal_twoid_event');
        },

        setIndexTo(items) {
            items.forEach((item, index) => {
            item.index = this.tableRows - (this.perPage * (this.currentPage - 1) + index);
            }, this);
        },

        convertStatusCd(statusCd){
            switch (statusCd) {
                case "A":
                    return "진행중";
                case "E":
                    return "만료";
                case "R":
                    return "예약";
            }
        },

        convertDate(date){
            return this.$moment(date).format('YYYY-MM-DD');
        },

    }
  }

</script>

<style >

</style>