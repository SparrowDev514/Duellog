import { createRouter, createWebHistory } from "vue-router";
import { createApp } from "vue";
import App from "../App.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: () => import("../views/Home.vue"),
  },
  {
    path: "/registerDeck",
    name: "registerDeck",
    component: () => import("../views/RegisterDeck.vue"),
  },
  {
    path: "/registerRecord",
    name: "registerRecord",
    component: () => import("../views/RegisterRecord.vue"),
  },
  {
    path: "/readRecords",
    name: "readRecords",
    component: () => import("../views/ReadRecords.vue"),
  },
];
const router = createRouter({
  history: createWebHistory(),
  routes,
});

const app = createApp(App);
app.use(router);
export default router;
