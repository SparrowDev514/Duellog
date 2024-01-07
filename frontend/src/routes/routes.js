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
  {
    path: "/settings",
    name: "Settings",
    component: () => import("../views/Settings.vue"),
  },
];
const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
