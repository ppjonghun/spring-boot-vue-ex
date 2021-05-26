import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../App.vue'
import TwoidEvent from '../pages/event/twoid/index.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
        path: '/',
        component: TwoidEvent
    }

  ]
})