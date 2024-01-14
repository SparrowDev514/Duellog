import { createRouter, createWebHistory } from "vue-router";

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
    path: "/SelectDeck",
    name: "SelectDeck",
    component: () => import("../views/SelectDeck.vue"),
  },
  {
    path: "/results",
    name: "totalResults",
    component: () => import("../views/Results.vue"),
  },
  {
    path: "/results/:deckName",
    name: "deckNameResults",
    component: () => import("../views/Results.vue"),
  },
  {
    path: "/detail/results",
    name: "totalResultsDetail",
    component: () => import("../views/ResultsDetail.vue"),
  },
  {
    path: "/detail/results/:deckName",
    name: "resultsDetail",
    component: () => import("../views/ResultsDetail.vue"),
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
