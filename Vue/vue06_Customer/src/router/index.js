import Vue from "vue";
import VueRouter from "vue-router";


import CustomersList from "../components/CustomersList.vue";
import DetailCustomer from "../components/DetailCustomer.vue";
import SearchCustomers from "../components/SearchCustomers.vue";
import SearchCustomersById from "../components/SearchCustomersById.vue";
import AddCustomer from "../components/AddCustomer.vue";



Vue.use(VueRouter);

const routes = [
    // {
    //  path: "/",
    // name: "Home",
    //component: Home
    // },
    {
        path: "/",
        name: "customers",
        alias: "/customer",
        component: CustomersList
    },

    {
        path: "/detailcustomer/:id",
        name: "detailcustomer",
        component: DetailCustomer,
        props: true
    },

    {
        path: "/searchbyname",
        name: "searchbyname",
        component: SearchCustomers
    },

    {
        path: "/searchbyid",
        name: "searchbyid",
        component: SearchCustomersById
    },

    {
        path: "/add",
        name: "add",
        component: AddCustomer
    },

    {
        path: "/about",
        name: "About",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
            import ( /* webpackChunkName: "about" */ "../views/About.vue")
    }
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes
});

export default router;