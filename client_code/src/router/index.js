import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import zhongleiList from '@/views/pages/zhonglei/list'
import zhongleiDetail from '@/views/pages/zhonglei/formModel'
import zhongleiAdd from '@/views/pages/zhonglei/formAdd'
import rongshuxinxiList from '@/views/pages/rongshuxinxi/list'
import rongshuxinxiDetail from '@/views/pages/rongshuxinxi/formModel'
import rongshuxinxiAdd from '@/views/pages/rongshuxinxi/formAdd'
import syslogList from '@/views/pages/syslog/list'
import syslogDetail from '@/views/pages/syslog/formModel'
import syslogAdd from '@/views/pages/syslog/formAdd'
import rongshuziyuanList from '@/views/pages/rongshuziyuan/list'
import rongshuziyuanDetail from '@/views/pages/rongshuziyuan/formModel'
import rongshuziyuanAdd from '@/views/pages/rongshuziyuan/formAdd'
import storeupList from '@/views/pages/storeup/list'
import newsList from '@/views/pages/news/list'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'zhongleiList',
			component: zhongleiList
		}, {
			path: 'zhongleiDetail',
			component: zhongleiDetail
		}, {
			path: 'zhongleiAdd',
			component: zhongleiAdd
		}
		, {
			path: 'rongshuxinxiList',
			component: rongshuxinxiList
		}, {
			path: 'rongshuxinxiDetail',
			component: rongshuxinxiDetail
		}, {
			path: 'rongshuxinxiAdd',
			component: rongshuxinxiAdd
		}
		, {
			path: 'syslogList',
			component: syslogList
		}, {
			path: 'syslogDetail',
			component: syslogDetail
		}, {
			path: 'syslogAdd',
			component: syslogAdd
		}
		, {
			path: 'rongshuziyuanList',
			component: rongshuziyuanList
		}, {
			path: 'rongshuziyuanDetail',
			component: rongshuziyuanDetail
		}, {
			path: 'rongshuziyuanAdd',
			component: rongshuziyuanAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'newsList',
			component: newsList
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
