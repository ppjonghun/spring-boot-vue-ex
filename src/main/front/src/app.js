import Vue from 'vue'
import App from './App.vue'
import '../assets/app.css'
import router from './router'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import axios from 'axios' // import axios

Vue.prototype.$axios = axios; // prototype에 axios 추가

Vue.use(BootstrapVue)

Vue.use(IconsPlugin)

Vue.use(require('vue-moment'))

Vue.config.productionTip = false
new Vue({
   el: '#app',
   router,
   render: h => h(App)
})