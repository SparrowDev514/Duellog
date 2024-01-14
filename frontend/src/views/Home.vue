<template>
    <v-app>
        <Header pageName="ホーム"></Header>
        <v-main>
            <v-container>
                <v-row>
                    <v-col col="12">
                        <v-btn block to="/registerDeck">デッキ登録 </v-btn>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-btn block to="/registerRecord">戦績登録 </v-btn>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-btn block to="/SelectDeck">戦績参照 </v-btn>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col col="12">
                        <v-btn block to="/settings">設定 </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>
<script setup>
import Header from '../components/Header.vue';
</script>