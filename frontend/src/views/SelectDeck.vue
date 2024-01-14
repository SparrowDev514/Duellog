<template>
    <v-app>
        <Header pageName="デッキ選択"></Header>
        <v-main>
            <v-dialog v-model=isLoading max-width="30%" max-height="30%">
                <v-card>
                    <ProgressLinear />
                </v-card>
            </v-dialog>
            <v-container>
                <v-row>
                    <v-col col="12">
                        <v-btn block to="/results">Total</v-btn>
                    </v-col>
                </v-row>
                <v-row v-for="deckName in  deckNames ">
                    <v-col col="12">
                        <v-btn block :to="'/results/' + `${deckName}`">{{ deckName }}</v-btn>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col=" 12">
                        <v-btn block>時間帯ごと</v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import Header from '../components/Header.vue';
import ProgressLinear from '../components/ProgressLinear.vue';
import axios from 'axios';
import { BASE_URL } from '../consts/consts';


const deckNames = ref([])
const isLoading = ref(false)

onMounted(() => {
    getDeckNames()
})

const getDeckNames = async () => {
    isLoading.value = true
    try {
        const response = await axios.get(BASE_URL + 'deck-name');
        deckNames.value = response.data
    } catch (error) {
        console.log(error);
    } finally {
        isLoading.value = false
    }
}
</script>