<template>
	<div class="home-preview">




		<!-- 商品推荐 -->
		<div id="animate_recommendjiajiaoxinxi" class="recommend animate__animated">
			<div class="recommend_title_box">
				<span class="recommend_title">家教信息推荐</span>
				<span class="recommend_subhead">{{'jiajiaoxinxi'.toUpperCase()}} RECOMMEND</span>
			</div>
			<div class="list list22 index-pv1">
				<div class="list-body-left">
					<div class="list-item1" @click="toDetail('jiajiaoxinxiDetail', jiajiaoxinxiRecommend[0])">
						<img v-if="preHttp(jiajiaoxinxiRecommend[0].fengmian)" :src="jiajiaoxinxiRecommend[0].fengmian.split(',')[0]" alt="" />
						<img v-else :src="baseUrl + (jiajiaoxinxiRecommend[0].fengmian?jiajiaoxinxiRecommend[0].fengmian.split(',')[0]:'')" alt="" />
						<div class="name">{{jiajiaoxinxiRecommend[0].kechengmingcheng}}</div>
						<div class="name">小时价格:{{jiajiaoxinxiRecommend[0].xiaoshijiage}}</div>
					</div>
					<div class="list-item2" @click="toDetail('jiajiaoxinxiDetail', jiajiaoxinxiRecommend[1])">
						<div class="img">
							<img v-if="preHttp(jiajiaoxinxiRecommend[1].fengmian)" :src="jiajiaoxinxiRecommend[1].fengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (jiajiaoxinxiRecommend[1].fengmian?jiajiaoxinxiRecommend[1].fengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{jiajiaoxinxiRecommend[1].kechengmingcheng}}</div>
							<div class="name">小时价格:{{jiajiaoxinxiRecommend[1].xiaoshijiage}}</div>
							<div class="bottom" >
								<div class="time">{{jiajiaoxinxiRecommend[1].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
					  </div>
					</div>
				</div>
				<div class="list-body-right">
					<div class="list-item1" @click="toDetail('jiajiaoxinxiDetail', jiajiaoxinxiRecommend[2])">
						<div class="img">
							<img v-if="preHttp(jiajiaoxinxiRecommend[2].fengmian)" :src="jiajiaoxinxiRecommend[2].fengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (jiajiaoxinxiRecommend[2].fengmian?jiajiaoxinxiRecommend[2].fengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{jiajiaoxinxiRecommend[2].kechengmingcheng}}</div>
							<div class="name">小时价格:{{jiajiaoxinxiRecommend[2].xiaoshijiage}}</div>
							<div class="bottom">
								<div class="time">{{jiajiaoxinxiRecommend[2].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
						</div>
					</div>
					<div class="list-item2" @click="toDetail('jiajiaoxinxiDetail', jiajiaoxinxiRecommend[3])">
						<div class="infoBox">
							<div class="name">{{jiajiaoxinxiRecommend[3].kechengmingcheng}}</div>
							<div class="name">小时价格:{{jiajiaoxinxiRecommend[3].xiaoshijiage}}</div>
							<div class="bottom">
								<div class="time">{{jiajiaoxinxiRecommend[3].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
						</div>
						<div class="img">
							<img v-if="preHttp(jiajiaoxinxiRecommend[3].fengmian)" :src="jiajiaoxinxiRecommend[3].fengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (jiajiaoxinxiRecommend[3].fengmian?jiajiaoxinxiRecommend[3].fengmian.split(',')[0]:'')" alt="" />
						</div>
					</div>
					<div class="list-item3" @click="toDetail('jiajiaoxinxiDetail', jiajiaoxinxiRecommend[4])">
						<div class="img">
							<img v-if="preHttp(jiajiaoxinxiRecommend[4].fengmian)" :src="jiajiaoxinxiRecommend[4].fengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (jiajiaoxinxiRecommend[4].fengmian?jiajiaoxinxiRecommend[4].fengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{jiajiaoxinxiRecommend[4].kechengmingcheng}}</div>
							<div class="name">小时价格:{{jiajiaoxinxiRecommend[4].xiaoshijiage}}</div>
							<div class="bottom">
								<div class="time">{{jiajiaoxinxiRecommend[4].addtime.split(' ')[0]}}</div>
							</div>
							<div class="jian"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('jiajiaoxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 商品推荐 -->
		<!-- 特价商品 -->
		<div id="animate_listtongzhixinxi" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">通知信息展示</span>
				<span class="list_subhead">{{'tongzhixinxi'.toUpperCase()}} SHOW</span>
			</div>
			<div class="list list23 index-pv1">
				<div class="list-body">
					<div class="list-body-top">
						<div class="img">
							<img v-if="preHttp(tongzhixinxiList[0].tupian)" :src="tongzhixinxiList[0].tupian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (tongzhixinxiList[0].tupian?tongzhixinxiList[0].tupian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{tongzhixinxiList[0].gonggaomingcheng}}</div>
							<div class="name">{{tongzhixinxiList[0].fabushijian}}</div>
							<div class="desc">{{tongzhixinxiList[0].gonggaoneirong}}</div>

							<div class="centerInfo">
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{tongzhixinxiList[0].addtime.split(' ')[0]}}</span>
								</div>
							</div>
							<div class="bottomInfo">
								<div class="more_btn" class="btn" @click="toDetail('tongzhixinxiDetail', tongzhixinxiList[0])">
									<span class="text">查看更多</span>
									<span class="icon iconfont icon-gengduo1"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="list-body-bottom">
						<div v-if="index>0&&index< (Number(7) - 1)" class="list-item" v-for="(item,index) in tongzhixinxiList" :key="index" @click="toDetail('tongzhixinxiDetail', item)">
							<div class="img">
								<img v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
								<img v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
							</div>
							<div class="infoBox">
								<div class="name">{{item.gonggaomingcheng}}</div>
								<div class="name">{{item.fabushijian}}</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('tongzhixinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
		<!-- 特价商品 -->
		<div id="animate_listhuodongxinxi" class="lists animate__animated">
			<div class="list_title_box">
				<span class="list_title">活动信息展示</span>
				<span class="list_subhead">{{'huodongxinxi'.toUpperCase()}} SHOW</span>
			</div>
			<div class="list list23 index-pv1">
				<div class="list-body">
					<div class="list-body-top">
						<div class="img">
							<img v-if="preHttp(huodongxinxiList[0].fengmian)" :src="huodongxinxiList[0].fengmian.split(',')[0]" alt="" />
							<img v-else :src="baseUrl + (huodongxinxiList[0].fengmian?huodongxinxiList[0].fengmian.split(',')[0]:'')" alt="" />
						</div>
						<div class="infoBox">
							<div class="name">{{huodongxinxiList[0].huodongmingcheng}}</div>
							<div class="name">开始时间:{{huodongxinxiList[0].kaishishijian}}</div>
							<div class="name">{{huodongxinxiList[0].huodongdidian}}</div>
							<div class="desc">{{huodongxinxiList[0].huodongxiangqing}}</div>

							<div class="centerInfo">
								<div class="time_item">
									<span class="icon iconfont icon-shijian21"></span>
									<span class="label">发布时间：</span>
									<span class="text">{{huodongxinxiList[0].addtime.split(' ')[0]}}</span>
								</div>
								<div class="collect_item">
									<span class="icon iconfont icon-shoucang10"></span>
									<span class="label">收藏：</span>
									<span class="text">{{huodongxinxiList[0].storeupnum}}</span>
								</div>
								<div class="view_item">
									<span class="icon iconfont icon-chakan2"></span>
									<span class="label">浏览次数：</span>
									<span class="text">{{huodongxinxiList[0].clicknum}}</span>
								</div>
							</div>
							<div class="bottomInfo">
								<div class="more_btn" class="btn" @click="toDetail('huodongxinxiDetail', huodongxinxiList[0])">
									<span class="text">查看更多</span>
									<span class="icon iconfont icon-gengduo1"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="list-body-bottom">
						<div v-if="index>0&&index< (Number(7) - 1)" class="list-item" v-for="(item,index) in huodongxinxiList" :key="index" @click="toDetail('huodongxinxiDetail', item)">
							<div class="img">
								<img v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
								<img v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
							</div>
							<div class="infoBox">
								<div class="name">{{item.huodongmingcheng}}</div>
								<div class="name">开始时间:{{item.kaishishijian}}</div>
								<div class="name">{{item.huodongdidian}}</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('huodongxinxi')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
	

		</div>
		<!-- 特价商品 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				newsList: [],
				jiajiaoxinxiRecommend: [],

				tongzhixinxiList: [],
				huodongxinxiList: [],




			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},

			listIndexClick23(index, name) {
				this['listIndex23' + name] = index[this['listColumn23' + name]]
				this.getList()
			},

			handleScroll() {
				let arr = [
					{id:'about',css:'animate__'},
					{id:'system',css:'animate__'},
					{id:'animate_listtongzhixinxi',css:'animate__'},
					{id:'animate_recommendjiajiaoxinxi',css:'animate__'},
					{id:'animate_listhuodongxinxi',css:'animate__'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
				autoSortUrl = "jiajiaoxinxi/autoSort";
				if(localStorage.getItem('frontToken')) {
					autoSortUrl = "jiajiaoxinxi/autoSort2";
				}
				data = {
					page: 1,
					limit: 8,
				}
				this.$http.get(autoSortUrl, {params: data}).then(res => {
					if (res.data.code == 0) {
						this.jiajiaoxinxiRecommend = res.data.data.list;
					}
				});
			
				data = {
					page: 1,
					limit: 7,
				}
				this.$http.get('tongzhixinxi/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.tongzhixinxiList = res.data.data.list;
					}
				});
				data = {
					page: 1,
					limit: 7,
				}
				this.$http.get('huodongxinxi/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.huodongxinxiList = res.data.data.list;
					}
				});
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		.recommend {
			padding: 0;
			margin: 20px 0 0;
			background: #fff;
			width: 100%;
			position: relative;
			.recommend_title_box {
				padding: 0 50px;
				margin: 50px auto 0;
				background: #03cce9;
				width: 1200px;
				text-align: left;
				height: 40px;
				.recommend_title {
					padding: 0 60px;
					margin: -24px 0 0;
					color: #fff;
					background: url(http://codegen.caihongy.cn/20240918/f134e912df3547dd88a98afc1da8b24b.png) no-repeat center top / 100% 100% ;
					display: inline-block;
					width: auto;
					font-size: 22px;
					line-height: 68px;
					height: 64px;
				}
				.recommend_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list22 {
				margin: 30px auto 0;
				overflow: hidden;
				display: flex;
				width: 1200px;
				justify-content: space-between;
				.list-body-left {
					width: 49.5%;
					.list-item1 {
						border: 1px solid #eee;
						margin: 0 0 6px;
						overflow: hidden;
						display: block;
						width: 100%;
						position: relative;
						height: 390px;
						img {
							object-fit: cover;
							display: block;
							width: 100%;
							transition: all 0.3s;
							height: 100%;
						}
						.name {
							padding: 0 0 0 20px;
							z-index: 100;
							background-size: 100%;
							color: #fff;
							white-space: nowrap;
							bottom: 0;
							display: block;
							font-size: 15px;
							line-height: 40px;
							text-overflow: ellipsis;
							box-sizing: border-box;
							overflow: hidden;
							left: 0;
							background: rgba(0,0,0,.2);
							width: 100%;
							position: absolute;
							height: 40px;
						}
					}
					.list-item1:hover {
						img {
							cursor: pointer;
							transform: scale(1.05);
						}
						.name {
						}
					}
					.list-item2 {
						cursor: pointer;
						display: flex;
						width: 100%;
						.img {
							border: 1px solid #eee;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 5px 10px 0 10px;
							z-index: 100;
							background: #fcfcfc;
							width: 50%;
							position: relative;
							box-sizing: border-box;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #f00;
								font-size: 16px;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #666;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #747474;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #999;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 28px;
									text-align: right;
									height: 28px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(100% 1%, 100% 100%, 0% 50%);
								top: 50%;
								left: -8px;
								background: #fcfcfc;
								width: 9px;
								position: absolute;
								height: 14px;
							}
						}
					}
					.list-item2:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							background: #03cce9;
							.name {
								color: #fff;
							}
							.price {
								color: #fff;
							}
							.desc {
								color: #fff;
								border-color: #dadada;
							}
							.bottom {
								.publisher {
									color: #fff;
								}
								.time {
									color: #eee;
								}
							}
							.jian {
								background: #03cce9;
							}
						}
					}
				}
				.list-body-right {
					width: 49.5%;
					.list-item1 {
						cursor: pointer;
						margin: 0 0 6px;
						display: flex;
						width: 100%;
						.img {
							border: 1px solid #eee;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 5px 10px 0 10px;
							z-index: 100;
							background: #fcfcfc;
							width: 50%;
							position: relative;
							box-sizing: border-box;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #f00;
								font-size: 16px;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #808080;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #666;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #999;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 24px;
									text-align: right;
									height: 24px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(100% 1%, 100% 100%, 0% 50%);
								top: 50%;
								left: -8px;
								background: #fcfcfc;
								width: 9px;
								position: absolute;
								height: 14px;
							}
						}
					}
					.list-item1:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							background: #03cce9;
							.name {
								color: #fff;
							}
							.price {
								color: #fff;
							}
							.desc {
								color: #fff;
								border-color: #dadada;
							}
							.bottom {
								.publisher {
									color: #fff;
								}
								.time {
									color: #eee;
								}
							}
							.jian {
								background: #03cce9;
							}
						}
					}
					.list-item2 {
						cursor: pointer;
						margin: 0 0 6px;
						display: flex;
						width: 100%;
						.img {
							border: 1px solid #eee;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 5px 10px 0 10px;
							z-index: 100;
							background: #fcfcfc;
							width: 50%;
							position: relative;
							box-sizing: border-box;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #f00;
								font-size: 16px;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #808080;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #666;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #999;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 24px;
									text-align: right;
									height: 24px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(0% 0%, 100% 50%, 0% 100%);
								top: 50%;
								background: #fcfcfc;
								width: 9px;
								position: absolute;
								right: -9px;
								height: 14px;
							}
						}
					}
					.list-item2:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							background: #03cce9;
							.name {
								color: #fff;
							}
							.price {
								color: #fff;
							}
							.desc {
								color: #fff;
								border-color: #dadada;
							}
							.bottom {
								.publisher {
									color: #fff;
								}
								.time {
									color: #eee;
								}
							}
							.jian {
								background: #03cce9;
							}
						}
					}
					.list-item3 {
						cursor: pointer;
						margin: 0 0 6px;
						display: flex;
						width: 100%;
						.img {
							border: 1px solid #eee;
							z-index: 50;
							overflow: hidden;
							width: 50%;
							position: relative;
							height: 192px;
							img {
								object-fit: cover;
								display: block;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							padding: 5px 10px 0 10px;
							z-index: 100;
							background: #fcfcfc;
							width: 50%;
							position: relative;
							box-sizing: border-box;
							height: 192px;
							.name {
								padding: 0 10px 0 0;
								margin: 0;
								overflow: hidden;
								color: #404040;
								white-space: nowrap;
								font-weight: 900;
								width: 100%;
								font-size: 15px;
								line-height: 24px;
								text-overflow: ellipsis;
								box-sizing: border-box;
								height: 24px;
							}
							.price {
								margin: 5px 0 0;
								color: #f00;
								font-size: 16px;
							}
							.desc {
								border: 1px dashed #dadada;
								padding: 5px 10px 0 0;
								margin: 5px 0 0;
								overflow: hidden;
								color: #808080;
								font-size: 14px;
								border-width: 1px 0 0;
								line-height: 24px;
								box-sizing: border-box;
								height: 48px;
							}
							.bottom {
								margin: 0;
								overflow: hidden;
								background: none;
								bottom: 5px;
								display: flex;
								width: calc(100% - 20px);
								justify-content: space-between;
								position: absolute;
								.publisher {
									color: #666;
									width: calc(100% - 110px);
									font-size: 14px;
								}
								.time {
									color: #747474;
									display: inline;
									width: 110px;
									font-size: 14px;
									line-height: 28px;
									text-align: right;
									height: 28px;
								}
							}
							.jian {
								margin: -7px 0 0;
								clip-path: polygon(100% 1%, 100% 100%, 0% 50%);
								top: 50%;
								left: -8px;
								background: #fcfcfc;
								width: 9px;
								position: absolute;
								height: 14px;
							}
						}
					}
					.list-item3:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							background: #03cce9;
							.name {
								color: #fff;
							}
							.price {
								color: #fff;
							}
							.desc {
								color: #fff;
								border-color: #dadada;
							}
							.bottom {
								.publisher {
									color: #fff;
								}
								.time {
									color: #eee;
								}
							}
							.jian {
								background: #03cce9;
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 40px auto;
				top: 0;
				background: #f7db61;
				display: block;
				width: 110px;
				line-height: 32px;
				position: absolute;
				right: calc((100% - 1200px)/2);
				text-align: center;
				.text {
					color: #333;
					font-size: 15px;
				}
				.icon {
					color: #333;
					font-size: 15px;
				}
			}
		}
		.lists {
			padding: 10px 0 20px;
			margin: 0;
			background: #fff;
			width: 100%;
			position: relative;
			order: 2;
			.list_title_box {
				padding: 0 50px;
				margin: 50px auto 0;
				background: #03cce9;
				width: 1200px;
				position: relative;
				text-align: left;
				height: 40px;
				.list_title {
					padding: 0 60px;
					margin: -24px 0 0;
					color: #fff;
					background: url(http://codegen.caihongy.cn/20240918/f134e912df3547dd88a98afc1da8b24b.png) no-repeat center top / 100% 100% ;
					display: inline-block;
					width: auto;
					font-size: 22px;
					line-height: 68px;
					height: 64px;
				}
				.list_subhead {
					margin: 0 0 10px;
					color: #999;
					display: none;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, -10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list23 {
				padding: 0;
				margin: 0 auto;
				overflow: hidden;
				background: none;
				width: 1220px;
				.tab_view {
					margin: 30px 0 0;
					display: flex;
					width: calc(100% - 20px);
					justify-content: center;
					align-items: center;
					.tab {
						border: 1px solid #03abe930;
						border-radius: 5px;
						padding: 2px 10px;
						margin: 0 10px;
						background: #fff;
						display: flex;
						justify-content: center;
						align-items: center;
						transition: 0.3s;
						min-width: 96px;
						img {
							border-radius: 50%;
							margin: 0 10px 0 0;
							width: 40px;
							transition: 0.3s;
							height: 40px;
						}
						.text {
							color: #000;
							display: block;
							font-size: 16px;
							line-height: 50px;
							transition: 0.3s;
							text-align: center;
							height: 50px;
						}
					}
					.tab:hover {
						border: 1px solid #03abe9;
						cursor: pointer;
						background: #03abe9;
						transition: all 0s;
						img {
							border-radius: 50%;
						}
						.text {
							color: #fff;
						}
					}
					.tab.tabActive {
						border: 1px solid #03abe9;
						color: #000;
						background: #03abe9;
						min-width: 96px;
						img {
							border-radius: 50%;
						}
						.text {
							color: #fff;
						}
					}
				}
				.list-body {
					margin: 40px 0 0;
					.list-body-top {
						margin: 0 auto;
						display: flex;
						width: calc(100% - 20px);
						justify-content: space-between;
						align-items: center;
						.img {
							overflow: hidden;
							width: 600px;
							height: 450px;
							img {
								object-fit: cover;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							background-color: #fff;
							padding: 40px 30px;
							flex: 1;
							box-sizing: border-box;
							height: 450px;
							.name {
								overflow: hidden;
								white-space: nowrap;
								width: 100%;
								font-size: 20px;
								line-height: 30px;
								text-overflow: ellipsis;
							}
							.desc {
								margin: 20px 0;
								color: #666;
								width: 100%;
								font-size: 15px;
								line-height: 1.8;
								text-align: justify;
							}
							.centerInfo {
								color: #888;
								display: flex;
								width: 100%;
								font-size: 15px;
								flex-wrap: wrap;
								.time_item {
									padding: 0 10px 0 0;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.publisher_item {
									padding: 0 10px 0 0;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.like_item {
									padding: 0 10px 0 0;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.collect_item {
									padding: 0 10px 0 0;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
								.view_item {
									padding: 0;
									.icon {
										margin: 0 2px 0 0;
										line-height: 1.5;
									}
									.label {
										line-height: 1.5;
									}
									.text {
										line-height: 1.5;
									}
								}
							}
							.bottomInfo {
								margin: 20px 0 0;
								display: flex;
								justify-content: space-between;
								align-items: center;
								.more_btn {
									border: 1px solid #ccc;
									color: #333;
									display: flex;
									font-size: 16px;
									line-height: 48px;
									transition: 0.2s;
									border-radius: 24px;
									background: #fff;
									width: 150px;
									justify-content: center;
									align-items: center;
									text-align: center;
									height: 48px;
									.text {
										padding: 0 5px 0 0;
										color: #666;
										font-size: 16px;
									}
									.icon {
										color: #666;
										font-size: 12px;
									}
								}
								.more_btn:hover {
									background: #03abe9;
									border-color: #03abe9;
									transition: all 0s;
									.text {
										color: #fff;
									}
									.icon {
										color: #fff;
									}
								}
								.price {
									margin: 10px 0 0;
									color: #6f6f6f;
									font-size: 16px;
									.price_text {
										color: #f00;
										font-weight: bold;
										display: inline-block;
										font-size: 32px;
									}
								}
							}
						}
					}
					.list-body-bottom {
						margin: 29px 0 0;
						display: flex;
						flex-wrap: wrap;
						.list-item {
							margin: 0 10px 20px;
							width: calc(33.33% - 20px);
							.img {
								overflow: hidden;
								width: 100%;
								height: 200px;
								img {
									object-fit: cover;
									width: 100%;
									transition: 0.3s;
									height: 100%;
								}
							}
							.infoBox {
								padding: 0 19px 5px;
								background: #fff;
								display: block;
								width: 100%;
								justify-content: space-between;
								align-items: center;
								position: relative;
								box-sizing: border-box;
								transition: 0.3s;
								height: auto;
								.name {
									overflow: hidden;
									max-width: calc(100% - 110px);
									white-space: nowrap;
									background: none;
									width: auto;
									font-size: 15px;
									line-height: 34px;
									text-overflow: ellipsis;
									transition: 0.3s;
									height: 30px;
								}
								.price {
									color: #6f6f6f;
									white-space: nowrap;
									bottom: 0px;
									background: none;
									width: auto;
									font-size: 16px;
									position: absolute;
									right: 10px;
									transition: 0.3s;
									text-align: right;
									.price_text {
										color: #f00;
										font-weight: bold;
										display: inline-block;
										font-size: 24px;
										transition: 0.3s;
									}
								}
							}
						}
						.list-item:hover {
							cursor: pointer;
							.img {
								img {
									transform: scale(1.1);
								}
							}
							.infoBox {
								background: #03abe9;
								transition: all 0s;
								.name {
									color: #fff;
								}
								.price {
									color: #fff;
									.price_text {
										color: #fff;
									}
								}
							}
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 40px auto;
				top: 0;
				background: #f7db61;
				display: block;
				width: 110px;
				line-height: 32px;
				position: absolute;
				right: calc((100% - 1200px)/2);
				text-align: center;
				.text {
					color: #333;
					font-size: 15px;
				}
				.icon {
					color: #333;
					font-size: 15px;
				}
			}
		}
	}
</style>
