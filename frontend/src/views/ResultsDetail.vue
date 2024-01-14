<template>
    <v-app>
        <Header :pageName=pageName></Header>
        <v-main>
            <v-dialog v-model=isLoading max-width="30%" max-height="30%">
                <v-card>
                    <ProgressLinear />
                </v-card>
            </v-dialog>
            <v-container>
                <div v-for="result in results" :key="result.deckName">
                    <v-row class="d-flex align-center">
                        <v-col cols="4">
                            <p class="text-h6"> 試合数：{{ result.numOfButtle }} </p>
                            <p class="text-h6"> {{ result.opponentDeck ? result.opponentDeck : "不明" }}
                            </p>
                        </v-col>
                        <v-col cols="8">
                            <v-progress-circular :size="150" :width="75" :model-value="result.winRatio * 100"
                                color="#add8e6">
                            </v-progress-circular>
                        </v-col>
                    </v-row>
                </div>
            </v-container>
        </v-main>
    </v-app>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import Header from '../components/Header.vue';
import ProgressLinear from '../components/ProgressLinear.vue';
import axios from 'axios';
import { BASE_URL } from '../consts/consts';


const route = useRoute()
const isLoading = ref(false)
const results = ref([])
const pageName = ref(route.params.deckName ? route.params.deckName : "トータル")

onMounted(() => {
    getRecord()
})

const getRecord = async () => {
    isLoading.value = true

    try {
        const response = await axios.get(BASE_URL + 'result/detail', {
            params: { deckName: route.params.deckName ? route.params.deckName : null }
        });
        results.value = response.data
    } catch (error) {
        console.error(error);
    } finally {
        isLoading.value = false
    }
}
</script>