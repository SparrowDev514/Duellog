<template>
    <v-app>
        <Header pageName="戦績登録"></Header>
        <v-main>
            <v-dialog v-model="isLoading" max-width="30%" max-height="30%">
                <v-card>
                    <ProgressLinear />
                </v-card>
            </v-dialog>
            <v-container>
                <v-row>
                    <v-col col="12">
                        <v-select clearable :rules="rules" :items="deckNames" v-model="myDeckName" label="デッキを選択" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-select :items="先手後手" item-title="hand" item-value="isFirst" v-model="isFirst" label="先後を選択" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-select :items="勝敗" item-title="result" item-value="isWon" v-model="isWon" label="勝敗を選択" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-select clearable :items="categories" v-model="opponentDeckCategory" label="相手のデッキを選択" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-btn :disabled="!myDeckName" @click="sendRecord">登録</v-btn>
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

const 先手後手 = [
    { hand: '先手', isFirst: true },
    { hand: '後手', isFirst: false }
]
const 勝敗 = [
    { result: 'win', isWon: true },
    { result: 'lose', isWon: false }
]

const myDeckName = defineModel("myDeckName")
const opponentDeckCategory = defineModel("opponentDeckCategory")
const isFirst = defineModel("isFirst", { default: true })
const isWon = defineModel("isWon", { default: true })

const deckNames = ref([])
const categories = ref([])
const isLoading = ref(false)
const rules = [
    value => {
        if (value) return true
        return 'デッキを入力してください'
    },
]

onMounted(() => {
    getDeckNames()
    getCategories()
})

const getDeckNames = async () => {
    isLoading.value = true
    try {
        const response = await axios.get('http://localhost:8080/api/deck-name');
        deckNames.value = response.data
    } catch (error) {
        console.log(error);
    } finally {
        isLoading.value = false

    }
}

const getCategories = async () => {
    isLoading.value = true
    try {
        const response = await axios.get('http://localhost:8080/api/categories');
        categories.value = response.data
    } catch (error) {
        console.log(error);
    } finally {
        isLoading.value = false

    }
}

const sendRecord = async () => {
    isLoading.value = true
    const body = {
        myDeckName: myDeckName.value,
        opponentDeckCategory: opponentDeckCategory.value,
        isFirst: isFirst.value,
        isWon: isWon.value,
    }
    try {
        await axios.put('http://localhost:8080/api/records', body);
    } catch (error) {
        console.log(error);
    } finally {
        isLoading.value = false

    }
}
</script>