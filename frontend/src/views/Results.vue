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
                <v-row>
                    <v-col cols="12">
                        <p class="font-weight-black text-h4"> 試合数：{{ results.numOfButtle }} </p>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="12">
                        <v-progress-circular :size="300" :width="80" :model-value="results.winRatio * 100" color="#add8e6">
                            <template v-slot:default>
                                <p class="font-weight-black text-h4"> 勝率</p>
                            </template>
                        </v-progress-circular>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="12">
                        <v-progress-circular :size="300" :width="80" :model-value="results.firstRatio * 100"
                            color="#90ee90">
                            <template v-slot:default>
                                <p class="font-weight-black text-h4">先手率 </p>
                            </template>
                        </v-progress-circular>
                    </v-col>
                </v-row>
                <v-row v-if="results.numOfButtle !== 0">
                    <v-col cols="12">
                        <v-btn block :to="'/detail/results/' + `${deckNameInUrl}`">詳細 </v-btn>
                    </v-col>
                </v-row>
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

const route = useRoute()
const isLoading = ref(false)
const results = ref({})
const pageName = ref(route.params.deckName ? route.params.deckName : "トータル")
const deckNameInUrl = ref(route.params.deckName ? route.params.deckName : "")

onMounted(() => {
    getRecord()
})

const getRecord = async () => {
    isLoading.value = true

    try {
        const response = await axios.get('http://localhost:8080/api/result', {
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