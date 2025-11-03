import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import xuesheng from '@/views/modules/xuesheng/list'
	import jiajiao from '@/views/modules/jiajiao/list'
	import xuekefenlei from '@/views/modules/xuekefenlei/list'
	import discussjiajiaoxinxi from '@/views/modules/discussjiajiaoxinxi/list'
	import huodongxinxi from '@/views/modules/huodongxinxi/list'
	import syslog from '@/views/modules/syslog/list'
	import jiajiaoxinxi from '@/views/modules/jiajiaoxinxi/list'
	import systemnotice from '@/views/modules/systemnotice/list'
	import tousujianyi from '@/views/modules/tousujianyi/list'
	import jiazhang from '@/views/modules/jiazhang/list'
	import huodongbaoming from '@/views/modules/huodongbaoming/list'
	import tongzhixinxi from '@/views/modules/tongzhixinxi/list'
	import jiajiaoyuyue from '@/views/modules/jiajiaoyuyue/list'
	import xuexifankui from '@/views/modules/xuexifankui/list'
	import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/xuesheng',
		name: '学生',
		component: xuesheng
	}
	,{
		path: '/jiajiao',
		name: '家教',
		component: jiajiao
	}
	,{
		path: '/xuekefenlei',
		name: '学科分类',
		component: xuekefenlei
	}
	,{
		path: '/discussjiajiaoxinxi',
		name: '家教信息评论',
		component: discussjiajiaoxinxi
	}
	,{
		path: '/huodongxinxi',
		name: '活动信息',
		component: huodongxinxi
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/jiajiaoxinxi',
		name: '家教信息',
		component: jiajiaoxinxi
	}
	,{
		path: '/systemnotice',
		name: '系统公告',
		component: systemnotice
	}
	,{
		path: '/tousujianyi',
		name: '投诉建议',
		component: tousujianyi
	}
	,{
		path: '/jiazhang',
		name: '家长',
		component: jiazhang
	}
	,{
		path: '/huodongbaoming',
		name: '活动报名',
		component: huodongbaoming
	}
	,{
		path: '/tongzhixinxi',
		name: '通知信息',
		component: tongzhixinxi
	}
	,{
		path: '/jiajiaoyuyue',
		name: '家教预约',
		component: jiajiaoyuyue
	}
	,{
		path: '/xuexifankui',
		name: '学习反馈',
		component: xuexifankui
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
