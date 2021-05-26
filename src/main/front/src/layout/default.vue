<template>
    <div>
        <base-top/>
        <base-left-menu/>
        <h1>default vue</h1>
        <div class="app-content content">
            <div class="content-body">
                <router-view/>
            </div>
        </div>
    </div>
</template>

<script>
    import BaseLeftMenu from '../components/layout/BaseLeftMenu.vue';
    import BaseTop from '../components/layout/BaseTop.vue';

    export default {
        name: "default",

        components: {
            BaseTop,
            BaseLeftMenu,
        },
        head() {
            return {
                bodyAttrs: {
                    class: 'vertical-layout vertical-menu 2-columns menu-expanded fixed-navbar',
                    ['data-col']: '2-column',
                    ['data-color']  : 'bg-gradient-x-purple-blue',
                    ['data-menu'] : 'vertical-menu'
                },
                script: [
                    { src:'/vendors/js/vendors.min.js'},
                    { src:'/js/core/app-menu.js'},
                    { src:'/js/core/app.js'},
                ],
            }
        },

    }
</script>

<style scoped>
</style>