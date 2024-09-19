import { createRouter, createWebHashHistory } from 'vue-router'
import news from '@/views/news/list'
import rongshuziyuan from '@/views/rongshuziyuan/list'
import yonghu from '@/views/yonghu/list'
import zhonglei from '@/views/zhonglei/list'
import syslog from '@/views/syslog/list'
import discussrongshuxinxi from '@/views/discussrongshuxinxi/list'
import rongshuxinxi from '@/views/rongshuxinxi/list'
import config from '@/views/config/list'
import users from '@/views/users/list'

export const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue'),
  },
  {
    path: '/',
    name: '首页',
    component: () => import('../views/index'),
    children: [
      {
        path: '/',
        name: '首页',
        component: () => import('../views/HomeView.vue'),
        meta: {
          affix: true,
        },
      },
      {
        path: '/updatepassword',
        name: '修改密码',
        component: () => import('../views/updatepassword.vue'),
      },

      {
        path: '/news',
        name: '新闻资讯',
        component: news,
      },
      {
        path: '/rongshuziyuan',
        name: '古树资源',
        component: rongshuziyuan,
      },
      {
        path: '/yonghu',
        name: '用户',
        component: yonghu,
      },
      {
        path: '/zhonglei',
        name: '种类',
        component: zhonglei,
      },
      {
        path: '/syslog',
        name: '系统日志',
        component: syslog,
      },
      {
        path: '/discussrongshuxinxi',
        name: '古树信息评论',
        component: discussrongshuxinxi,
      },
      {
        path: '/rongshuxinxi',
        name: '古树信息',
        component: rongshuxinxi,
      },
      {
        path: '/config',
        name: '轮播图',
        component: config,
      },
      {
        path: '/users',
        name: '管理员',
        component: users,
      },
    ],
  },
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes,
})

export default router
