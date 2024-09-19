<template>
  <div class="home_view">
    <div class="projectTitle">欢迎使用 {{ projectName }}</div>
    <div class="count_list">
      <el-collapse-transition v-if="btnAuth('rongshuxinxi', '首页总数')">
        <el-card
          v-show="countTypeList.closerongshuxinxiCountType"
          class="card_view"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">古树信息</div>
              <div class="card_head_right">
                <el-icon
                  @click="countTypeClick('hiddenrongshuxinxiCountType')"
                  class="showIcons"
                  :class="
                    countTypeList.hiddenrongshuxinxiCountType
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="countTypeClick('closerongshuxinxiCountType')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="count_item"
              v-show="countTypeList.hiddenrongshuxinxiCountType"
            >
              <div class="count_title">古树信息总数</div>
              <div class="count_num">{{ rongshuxinxiCount }}</div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
    </div>
    <div class="card_list">
      <el-collapse-transition v-if="btnAuth('rongshuxinxi', '首页统计')">
        <el-card
          v-show="cardTypeList.closerongshuxinxiChartType1"
          class="card_view"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">古树信息</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenrongshuxinxiChartType1')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenrongshuxinxiChartType1
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closerongshuxinxiChartType1')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenrongshuxinxiChartType1"
            >
              <div
                id="rongshuxinxishuliangEchart1"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
      <el-collapse-transition v-if="btnAuth('rongshuxinxi', '首页统计')">
        <el-card
          v-show="cardTypeList.closerongshuxinxiChartType2"
          class="card_view"
        >
          <template #header>
            <div class="index_card_head">
              <div class="card_head_title">古树信息</div>
              <div class="card_head_right">
                <el-icon
                  @click="cardTypeClick('hiddenrongshuxinxiChartType2')"
                  class="showIcons"
                  :class="
                    cardTypeList.hiddenrongshuxinxiChartType2
                      ? 'showIcons1'
                      : ''
                  "
                >
                  <ArrowUpBold />
                </el-icon>
                <el-icon
                  @click="cardTypeClick('closerongshuxinxiChartType2')"
                  class="closeIcons"
                >
                  <CloseBold />
                </el-icon>
              </div>
            </div>
          </template>
          <el-collapse-transition>
            <div
              class="card_item"
              v-show="cardTypeList.hiddenrongshuxinxiChartType2"
            >
              <div
                id="rongshuxinxishuliangEchart2"
                style="width: 100%; height: 400px"
              ></div>
            </div>
          </el-collapse-transition>
        </el-card>
      </el-collapse-transition>
    </div>
  </div>
</template>

<script setup>
import { inject, nextTick, ref, getCurrentInstance } from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties
const projectName = context.$project.projectName
const countTypeList = ref({})
const getCountList = () => {
  countTypeList.value.closerongshuxinxiCountType = true
  countTypeList.value.hiddenrongshuxinxiCountType = true
  if (btnAuth('rongshuxinxi', '首页总数')) {
    getrongshuxinxiCount()
  }
}
const rongshuxinxiCount = ref(0)
const getrongshuxinxiCount = () => {
  context
    ?.$http({
      url: 'rongshuxinxi/count',
      method: 'get',
    })
    .then((res) => {
      rongshuxinxiCount.value = res.data.data
    })
}
const countTypeClick = (e) => {
  countTypeList.value[e] = !countTypeList.value[e]
}
const init = () => {
  getCountList()
  getCardList()
}
//权限验证
const btnAuth = (e, a) => {
  return context?.$toolUtil.isAuth(e, a)
}
let echarts = inject('echarts')
const cardTypeClick = (e) => {
  cardTypeList.value[e] = !cardTypeList.value[e]
  setTimeout(() => {
    getCardList()
  }, 1000)
}
const cardTypeList = ref({
  closerongshuxinxiChartType1: true,
  hiddenrongshuxinxiChartType1: true,
  closerongshuxinxiChartType2: true,
  hiddenrongshuxinxiChartType2: true,
})
const getCardList = () => {
  if (btnAuth('rongshuxinxi', '首页统计')) {
    getrongshuxinxiChart1()
  }
  if (btnAuth('rongshuxinxi', '首页统计')) {
    getrongshuxinxiChart2()
  }
}
const getrongshuxinxiChart1 = () => {
  nextTick(() => {
    var shuliangEchart1 = echarts.init(
      document.getElementById('rongshuxinxishuliangEchart1'),
      'macarons'
    )
    context
      ?.$http({
        url: `rongshuxinxi/value/mingcheng/shuliang`,
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis = []
        let pArray = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].mingcheng)
          yAxis.push(parseFloat(res[i].total))
          pArray.push({
            value: parseFloat(res[i].total),
            name: res[i].mingcheng,
          })
        }
        var option = {}
        option = {
          title: {
            text: '古树数量统计',
            left: 'center',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}',
          },
          xAxis: {
            type: 'category',
            data: xAxis,
            axisLabel: {
              rotate: 40,
            },
          },
          yAxis: {
            type: 'value',
          },
          series: [
            {
              data: yAxis,
              type: 'bar',
            },
          ],
        }
        shuliangEchart1.clear()
        // 使用刚指定的配置项和数据显示图表。
        shuliangEchart1.setOption(option)
        //根据窗口的大小变动图表
        shuliangEchart1.resize()
      })
  })
}
const getrongshuxinxiChart2 = () => {
  nextTick(() => {
    var shuliangEchart2 = echarts.init(
      document.getElementById('rongshuxinxishuliangEchart2'),
      'macarons'
    )
    context
      ?.$http({
        url: `rongshuxinxi/value/fenbuweizhi/shuliang`,
        method: 'get',
      })
      .then((obj) => {
        let res = obj.data.data
        let xAxis = []
        let yAxis = []
        let pArray = []
        for (let i = 0; i < res.length; i++) {
          xAxis.push(res[i].fenbuweizhi)
          yAxis.push(parseFloat(res[i].total))
          pArray.push({
            value: parseFloat(res[i].total),
            name: res[i].fenbuweizhi,
          })
        }
        var option = {}
        option = {
          title: {
            text: '古树位置数量统计',
            left: 'center',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c}',
          },
          xAxis: {
            type: 'category',
            data: xAxis,
            axisLabel: {
              rotate: 40,
            },
          },
          yAxis: {
            type: 'value',
          },
          series: [
            {
              data: yAxis,
              type: 'bar',
            },
          ],
        }
        // 使用刚指定的配置项和数据显示图表。
        shuliangEchart2.clear()
        shuliangEchart2.setOption(option)
        //根据窗口的大小变动图表
        shuliangEchart2.resize()
      })
  })
}
init()
</script>
<style lang="scss">
.projectTitle {
  padding: 20px 0;
  margin: 20px 0 20px;
  color: #fff;
  font-weight: 500;
  display: flex;
  width: 100%;
  font-size: 24px;
  justify-content: center;
  align-items: center;
  height: auto;
}

.showIcons {
  transition: transform 0.3s;
  margin-right: 10px;
}

.showIcons1 {
  transform: rotate(-180deg);
}

// 总数盒子
.count_list {
  padding: 0 0 20px;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: flex-start;
  flex-wrap: wrap;
  // 总数card
  .card_view {
    border: 1px solid rgba(254, 182, 203, 0.5);
    border-radius: 0;
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.12);
    margin: 0 1% 20px;
    background: rgba(255, 255, 255, 0.5);
    flex: 1;
    width: 31%;
    box-sizing: border-box;
    height: auto;
    // card头部
    .el-card__header {
      border: 0px solid rgba(254, 182, 203, 0.5);
      background: rgba(255, 255, 255, 0.3);
      width: 100%;
      border-width: 0 0 1px;
      // 头部盒子
      .index_card_head {
        display: flex;
        width: 100%;
        justify-content: space-between;
        align-items: center;
        height: 10px;
        // 标题
        .card_head_title {
          color: #555;
          font-size: 14px;
        }
        // 按钮盒子
        .card_head_right {
          display: flex;
          align-items: center;
          // 按钮
          .el-icon {
            cursor: pointer;
            color: #666;
            font-size: 20px;
          }
        }
      }
    }
    // body
    .el-card__body {
      padding: 0;
      // body盒子
      .count_item {
        padding: 30px;
        text-align: center;
        // 总数标题
        .count_title {
          color: #333;
          font-size: 16px;
          line-height: 2;
        }
        // 总数数字
        .count_num {
          color: #f00;
          font-size: 30px;
          line-height: 2;
        }
      }
    }
  }
}
// 首页盒子
.home_view {
  padding: 0px 20px;
  margin: 0;
  background: url(http://localhost:8080/banyanTreeManage/file/3003369554f34c828841c05292b6461a.jpg)
    no-repeat center top / 100% 100% !important;
  min-height: 100vh;
  height: auto;
}
// 统计图盒子
.card_list {
  padding: 0 0 20px;
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
  // 统计图card
  .card_view {
    border: 1px solid rgba(254, 182, 203, 0.5);
    border-radius: 0;
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.12);
    margin: 0 1% 30px;
    background: rgba(255, 255, 255, 0.5);
    width: 48%;
    box-sizing: border-box;
    height: auto;
    // 头部
    .el-card__header {
      border: 0px solid rgba(254, 182, 203, 0.5);
      background: rgba(255, 255, 255, 0.3);
      width: 100%;
      border-width: 0 0 1px;
      // 头部盒子
      .index_card_head {
        display: flex;
        width: 100%;
        justify-content: space-between;
        align-items: center;
        height: 10px;
        // 标题
        .card_head_title {
          color: #555;
          font-size: 14px;
        }
        // 按钮盒子
        .card_head_right {
          display: flex;
          align-items: center;
          // 按钮
          .el-icon {
            cursor: pointer;
            color: #666;
            font-size: 20px;
          }
        }
      }
    }
    // body
    .el-card__body {
      padding: 0;
      // body盒子
      .card_item {
        padding: 30px;
        text-align: center;
      }
    }
  }
}
</style>
