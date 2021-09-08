import Vue from "vue";
import App from "./App.vue";
import router from './router'

Vue.config.productionTip = false;

new Vue({
    router,
    render: h => h(App)
}).$mount("#app");
/*
Vue 인스턴스 생성...
App.vue를 등록
#app 화면영역에 마운트 된다

::

html의 app영역을 찾아서 그 부분이 Vue 템플릿으로 관리하도록 마운트 한다
  
},
*/