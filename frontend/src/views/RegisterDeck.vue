<template>
    <v-app>
        <Header page-name="デッキ登録"></Header>
        <v-main>
            <v-container>
                <v-row>
                    <v-col cols="12">
                        <v-text-field label="メインカテゴリ" v-model="main"></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="12">
                        <v-text-field label="サブカテゴリ１" v-model="sub1"></v-text-field>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="12">
                        <v-text-field label="サブカテゴリ２" v-model="sub2"></v-text-field>
                    </v-col>
                </v-row>
            </v-container>
            <v-btn @click="sendRequest">登録</v-btn>
        </v-main>
    </v-app>
</template>
<script setup>
import Header from '../components/Header.vue';
import axios from 'axios';

const main = defineModel("main")
const sub1 = defineModel("sub1")
const sub2 = defineModel("sub2")

const sendRequest = async () => {
    const headers = {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
    }

    const body = {
        main: main.value,
        sub1: sub1.value,
        sub2: sub2.value,
    }

    try {
        const response = await axios.put('http://localhost:8080/api/deck-name', body);
        console.log(response);
    } catch (error) {
        console.log(error);
    }
}
</script>