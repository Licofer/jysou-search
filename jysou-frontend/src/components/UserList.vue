<template>
  <a-list item-layout="horizontal" :data-source="userList">
    <template #renderItem="{ item }">
      <a-list-item>
        <a-card hoverable style="width: 240px">
          <template #cover>
            <img alt="example" :src="tx" />
          </template>
          <a-card-meta :title="item.userName">
            <template #description>{{ item.userProfile }}</template>
          </a-card-meta>
        </a-card>
      </a-list-item>
    </template>
  </a-list>
</template>

<script setup lang="ts">
import tx from "../assets/tx.jpg";
import { withDefaults, defineProps } from "vue";

interface Props {
  userList: any[];
}

const props = withDefaults(defineProps<Props>(), {
  userList: () => [],
});
</script>

<style scoped>
.syc {
  width: 200px;
}
</style>
