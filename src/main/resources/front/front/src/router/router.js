import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import payList from '../pages/pay'

import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import jiazhangList from '../pages/jiazhang/list'
import jiazhangDetail from '../pages/jiazhang/detail'
import jiazhangAdd from '../pages/jiazhang/add'
import jiajiaoList from '../pages/jiajiao/list'
import jiajiaoDetail from '../pages/jiajiao/detail'
import jiajiaoAdd from '../pages/jiajiao/add'
import tongzhixinxiList from '../pages/tongzhixinxi/list'
import tongzhixinxiDetail from '../pages/tongzhixinxi/detail'
import tongzhixinxiAdd from '../pages/tongzhixinxi/add'
import xuekefenleiList from '../pages/xuekefenlei/list'
import xuekefenleiDetail from '../pages/xuekefenlei/detail'
import xuekefenleiAdd from '../pages/xuekefenlei/add'
import jiajiaoxinxiList from '../pages/jiajiaoxinxi/list'
import jiajiaoxinxiDetail from '../pages/jiajiaoxinxi/detail'
import jiajiaoxinxiAdd from '../pages/jiajiaoxinxi/add'
import jiajiaoyuyueList from '../pages/jiajiaoyuyue/list'
import jiajiaoyuyueDetail from '../pages/jiajiaoyuyue/detail'
import jiajiaoyuyueAdd from '../pages/jiajiaoyuyue/add'
import xuexifankuiList from '../pages/xuexifankui/list'
import xuexifankuiDetail from '../pages/xuexifankui/detail'
import xuexifankuiAdd from '../pages/xuexifankui/add'
import tousujianyiList from '../pages/tousujianyi/list'
import tousujianyiDetail from '../pages/tousujianyi/detail'
import tousujianyiAdd from '../pages/tousujianyi/add'
import huodongxinxiList from '../pages/huodongxinxi/list'
import huodongxinxiDetail from '../pages/huodongxinxi/detail'
import huodongxinxiAdd from '../pages/huodongxinxi/add'
import huodongbaomingList from '../pages/huodongbaoming/list'
import huodongbaomingDetail from '../pages/huodongbaoming/detail'
import huodongbaomingAdd from '../pages/huodongbaoming/add'
import syslogList from '../pages/syslog/list'
import syslogDetail from '../pages/syslog/detail'
import syslogAdd from '../pages/syslog/add'
import popupremindList from '../pages/popupremind/list'
import popupremindDetail from '../pages/popupremind/detail'
import popupremindAdd from '../pages/popupremind/add'
import systemnoticeList from '../pages/systemnotice/list'
import systemnoticeDetail from '../pages/systemnotice/detail'
import systemnoticeAdd from '../pages/systemnotice/add'
import discussjiajiaoxinxiList from '../pages/discussjiajiaoxinxi/list'
import discussjiajiaoxinxiDetail from '../pages/discussjiajiaoxinxi/detail'
import discussjiajiaoxinxiAdd from '../pages/discussjiajiaoxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'jiazhang',
					component: jiazhangList
				},
				{
					path: 'jiazhangDetail',
					component: jiazhangDetail
				},
				{
					path: 'jiazhangAdd',
					component: jiazhangAdd
				},
				{
					path: 'jiajiao',
					component: jiajiaoList
				},
				{
					path: 'jiajiaoDetail',
					component: jiajiaoDetail
				},
				{
					path: 'jiajiaoAdd',
					component: jiajiaoAdd
				},
				{
					path: 'tongzhixinxi',
					component: tongzhixinxiList
				},
				{
					path: 'tongzhixinxiDetail',
					component: tongzhixinxiDetail
				},
				{
					path: 'tongzhixinxiAdd',
					component: tongzhixinxiAdd
				},
				{
					path: 'xuekefenlei',
					component: xuekefenleiList
				},
				{
					path: 'xuekefenleiDetail',
					component: xuekefenleiDetail
				},
				{
					path: 'xuekefenleiAdd',
					component: xuekefenleiAdd
				},
				{
					path: 'jiajiaoxinxi',
					component: jiajiaoxinxiList
				},
				{
					path: 'jiajiaoxinxiDetail',
					component: jiajiaoxinxiDetail
				},
				{
					path: 'jiajiaoxinxiAdd',
					component: jiajiaoxinxiAdd
				},
				{
					path: 'jiajiaoyuyue',
					component: jiajiaoyuyueList
				},
				{
					path: 'jiajiaoyuyueDetail',
					component: jiajiaoyuyueDetail
				},
				{
					path: 'jiajiaoyuyueAdd',
					component: jiajiaoyuyueAdd
				},
				{
					path: 'xuexifankui',
					component: xuexifankuiList
				},
				{
					path: 'xuexifankuiDetail',
					component: xuexifankuiDetail
				},
				{
					path: 'xuexifankuiAdd',
					component: xuexifankuiAdd
				},
				{
					path: 'tousujianyi',
					component: tousujianyiList
				},
				{
					path: 'tousujianyiDetail',
					component: tousujianyiDetail
				},
				{
					path: 'tousujianyiAdd',
					component: tousujianyiAdd
				},
				{
					path: 'huodongxinxi',
					component: huodongxinxiList
				},
				{
					path: 'huodongxinxiDetail',
					component: huodongxinxiDetail
				},
				{
					path: 'huodongxinxiAdd',
					component: huodongxinxiAdd
				},
				{
					path: 'huodongbaoming',
					component: huodongbaomingList
				},
				{
					path: 'huodongbaomingDetail',
					component: huodongbaomingDetail
				},
				{
					path: 'huodongbaomingAdd',
					component: huodongbaomingAdd
				},
				{
					path: 'syslog',
					component: syslogList
				},
				{
					path: 'syslogDetail',
					component: syslogDetail
				},
				{
					path: 'syslogAdd',
					component: syslogAdd
				},
				{
					path: 'popupremind',
					component: popupremindList
				},
				{
					path: 'popupremindDetail',
					component: popupremindDetail
				},
				{
					path: 'popupremindAdd',
					component: popupremindAdd
				},
				{
					path: 'systemnotice',
					component: systemnoticeList
				},
				{
					path: 'systemnoticeDetail',
					component: systemnoticeDetail
				},
				{
					path: 'systemnoticeAdd',
					component: systemnoticeAdd
				},
				{
					path: 'discussjiajiaoxinxi',
					component: discussjiajiaoxinxiList
				},
				{
					path: 'discussjiajiaoxinxiDetail',
					component: discussjiajiaoxinxiDetail
				},
				{
					path: 'discussjiajiaoxinxiAdd',
					component: discussjiajiaoxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
