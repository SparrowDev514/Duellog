<template>
    <v-app-bar>
        <template v-slot:prepend v-if="route.path !== '/'" />
        <v-app-bar-title>{{ pageName }}</v-app-bar-title>
    </v-app-bar>
</template>
<script setup>
import { useRoute } from 'vue-router';

const route = useRoute();
const props = defineProps({ 'pageName': String })
</script>