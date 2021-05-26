<template>
    <b-modal id="modal_twoid_event" :title="title" @show="showModal" @ok="ok">

        <b-form ref="form">
            <b-form-group id="input-group-1" label="이벤트명" label-for="input-1">
                <b-form-input id="input-1" required="required" v-model="modalEventNm"></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="시작일" label-for="input-2">
                <b-form-datepicker id="input-2" required v-model="modalStartDt"></b-form-datepicker>
            </b-form-group>

            <b-form-group id="input-group-3" label="종료일" label-for="input-3">
                <b-form-datepicker id="input-3" required v-model="modalEndDt"></b-form-datepicker>
            </b-form-group>
        </b-form>
        <template #modal-footer="{ ok, cancel, hide }">
            <b-button variant="light" @click="hide">
            닫기
            </b-button>
            <b-button v-if="btnShow" variant="danger" @click="deleteEvent">
            삭제
            </b-button>
            <b-button variant="primary" @click="ok">
            확인
            </b-button>
        </template>
    </b-modal>
</template>

<script>
    export default {

        props : ['modalState', 'selectedTwoidEvent'],

        data() {
            return {
                title: '',
                modalEventNm: '',
                modalStartDt: '',
                modalEndDt: '',
                btnShow: ''
            }
        },

        methods:{

            showModal(){
                this.$nextTick(async () => {
                    if(this.$props.modalState === 'CREATE'){
                        this.title = "이벤트 등록";
                        this.modalEventNm = '';
                        this.modalStartDt = '';
                        this.modalEndDt = '';
                        this.btnShow = false;

                    }else{
                        //console.log(this.$props.selectedTwoidEvent);
                        this.title = "이벤트 수정";

                        this.modalEventNm = this.$props.selectedTwoidEvent.eventNm;
                        this.modalStartDt = this.$parent.convertDate(this.$props.selectedTwoidEvent.startDt);
                        this.modalEndDt = this.$parent.convertDate(this.$props.selectedTwoidEvent.endDt);

                        //console.log(this.$props.selectedTwoidEvent.statusCd);
                        if(this.$props.selectedTwoidEvent.statusCd === 'E'){
                            //console.log("보여===");
                            this.btnShow = true;
                        }else{
                            //console.log("안보여==");
                            this.btnShow = false;
                        }
                    }
                });
            },

            ok(bvModal) {
                bvModal.preventDefault();

                if(this.modalValueCheck())
                    return false;

                this.modalSubmit();
            },

            modalValueCheck(){
                if(this.modalEventNm === '' || this.modalStartDt === '' || this.modalEndDt === ''){
                    this.$bvModal.msgBoxOk('빈칸 !');
                    return false;
                }else if(this.$moment(this.modalEndDt).isBefore(this.modalStartDt)){
                    this.$bvModal.msgBoxOk('날짜 확인 !');
                    return false;
                }

                return true;
            },

            modalSubmit() {
                const params = {};
                let url = "";
                this.$nextTick(async () => {
                    console.log("submit >> ");

                    params.eventId = this.$props.selectedTwoidEvent.eventId;
                    params.eventNm = this.modalEventNm;
                    params.startDt = this.$moment(this.modalStartDt).format('YYYYMMDD');
                    params.endDt = this.$moment(this.modalEndDt).format('YYYYMMDD');

                    if(this.$props.modalState === 'CREATE')
                        url = "/twoidEvent/insertTwoidEvent";
                    else
                        url = "/twoidEvent/updateTwoidEvent";

                    await this.$axios({
                        method : 'post',
                        url : APP_LOCAL_API_URL + url,
                        data : params
                    });

                    this.$bvModal.hide('modal_twoid_event');
                    this.$parent.getOEList();
                });
            },

            async deleteEvent(){
                console.log("delete >>> " + this.$props.selectedTwoidEvent.eventNm);

                const params = {};
                params.eventId = this.$props.selectedTwoidEvent.eventId;

                await this.$axios({
                    method : 'post',
                    url : APP_LOCAL_API_URL + '/twoidEvent/deleteTwoidEvent',
                    data : params
                });

                this.$bvModal.hide('modal_twoid_event');
                this.$parent.getOEList();

            },

        }
    }
</script>

<style scoped>

</style>
