export default {
	baseUrl: 'http://localhost:8080/springboot484n4tm2/',
	name: '/springboot484n4tm2',
	indexNav: [
		{
			name: '通知信息',
			url: '/index/tongzhixinxi',
		},
		{
			name: '家教信息',
			url: '/index/jiajiaoxinxi',
		},
		{
			name: '活动信息',
			url: '/index/huodongxinxi',
		},
	],
	cateList: [
		{
			name: '家教信息',
			refTable: 'xuekefenlei',
			refColumn: 'xuekefenlei',
		},
	]
}
