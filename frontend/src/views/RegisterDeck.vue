<template>
    <v-app>
        <Header pageName="デッキ登録"></Header>
        <v-main>
            <v-dialog v-model=isLoading max-width="30%" max-height="30%">
                <v-card>
                    <ProgressLinear />
                </v-card>
            </v-dialog>
            <v-container>
                <v-row>
                    <v-col col="12">
                        <v-combobox clearable :rules="rules" :items="categories" v-model="main" label="メインカテゴリ" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-combobox clearable :items="categories" v-model="sub1" label="サブカテゴリ１" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-combobox clearable :items="categories" v-model="sub2" label="サブカテゴリ２" />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-btn :disabled="!main" @click="registerDeckName">登録</v-btn>
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

const main = defineModel("main")
const sub1 = defineModel("sub1")
const sub2 = defineModel("sub2")

const categories = ref([])
const isLoading = ref(false)
const rules = [
    value => {
        if (value) return true
        return 'メインカテゴリを入力してください'
    },
]

onMounted(() => {
    getCategories()
})

const getCategories = async () => {
    isLoading.value = true
    try {
        const response = await axios.get(BASE_URL + 'categories');
        categories.value = response.data
    } catch (error) {
        console.log(error);
    } finally {
        isLoading.value = false

    }
}

const registerDeckName = async () => {
    isLoading.value = true
    const body = {
        main: main.value,
        sub1: sub1.value,
        sub2: sub2.value,
    }

    try {
        await axios.put(BASE_URL + 'deck-name', body);
        getCategories()
    } catch (error) {
        console.log(error);
    } finally {
        main.value = ""
        sub1.value = ""
        sub2.value = ""
        isLoading.value = false
    }
}
</script>
<style></style>