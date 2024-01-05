<template>
    <v-app>
        <Header page-name="ホーム"></Header>
        <v-main>
            <v-container>
                <v-row>
                    <v-col cols="12">
                        <v-btn to="/registerDeck">デッキ登録 </v-btn>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="12">
                        <v-btn to="/registerRecord">戦績登録 </v-btn>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="12">
                        <v-btn to="/readRecords">戦績参照 </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>
<script setup>
import Header from '../components/Header.vue';
</script>