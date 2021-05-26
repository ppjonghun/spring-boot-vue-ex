<template>
  <div id='app'>
        <router-view/>
  </div>
</template>

<script>
    import BaseLeftMenu from './components/layout/BaseLeftMenu.vue';
    export default{
    components: {
        BaseLeftMenu
      }
    }
</script>
<style scoped>
</style>