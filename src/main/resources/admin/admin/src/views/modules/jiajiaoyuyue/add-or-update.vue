<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'" label="预约编号" prop="yuyuebianhao" >
					<el-input v-model="ruleForm.yuyuebianhao" placeholder="预约编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yuyuebianhao" label="预约编号" prop="yuyuebianhao" >
					<el-input v-model="ruleForm.yuyuebianhao" placeholder="预约编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="课程名称" prop="kechengmingcheng" >
					<el-input v-model="ruleForm.kechengmingcheng" placeholder="课程名称" clearable  :readonly="ro.kechengmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="课程名称" prop="kechengmingcheng" >
					<el-input v-model="ruleForm.kechengmingcheng" placeholder="课程名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.fengmian" label="封面" prop="fengmian" >
					<file-upload
						tip="点击上传封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
						@change="fengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.fengmian" label="封面" prop="fengmian" >
					<img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="家教账号" prop="jiajiaozhanghao" >
					<el-input v-model="ruleForm.jiajiaozhanghao" placeholder="家教账号" clearable  :readonly="ro.jiajiaozhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="家教账号" prop="jiajiaozhanghao" >
					<el-input v-model="ruleForm.jiajiaozhanghao" placeholder="家教账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="家教姓名" prop="jiajiaoxingming" >
					<el-input v-model="ruleForm.jiajiaoxingming" placeholder="家教姓名" clearable  :readonly="ro.jiajiaoxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="家教姓名" prop="jiajiaoxingming" >
					<el-input v-model="ruleForm.jiajiaoxingming" placeholder="家教姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="小时价格" prop="xiaoshijiage" >
					<el-input v-model.number="ruleForm.xiaoshijiage" placeholder="小时价格" clearable  :readonly="ro.xiaoshijiage"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="小时价格" prop="xiaoshijiage" >
					<el-input v-model="ruleForm.xiaoshijiage" placeholder="小时价格" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="预约时间" prop="yuyueshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.yuyueshijian" 
						type="datetime"
						:readonly="ro.yuyueshijian"
						placeholder="预约时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yuyueshijian" label="预约时间" prop="yuyueshijian" >
					<el-input v-model="ruleForm.yuyueshijian" placeholder="预约时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="预约时长" prop="yuyueshizhang" >
					<el-input v-model.number="ruleForm.yuyueshizhang" placeholder="预约时长" clearable  :readonly="ro.yuyueshizhang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="预约时长" prop="yuyueshizhang" >
					<el-input v-model="ruleForm.yuyueshizhang" placeholder="预约时长" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="预约地址" prop="yuyuedizhi" >
					<el-input v-model="ruleForm.yuyuedizhi" placeholder="预约地址" clearable  :readonly="ro.yuyuedizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="预约地址" prop="yuyuedizhi" >
					<el-input v-model="ruleForm.yuyuedizhi" placeholder="预约地址" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="总金额" prop="zongjine" >
					<el-input v-model="zongjine" placeholder="总金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.zongjine" label="总金额" prop="zongjine" >
					<el-input v-model="ruleForm.zongjine" placeholder="总金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="备注" prop="beizhu" >
					<el-input v-model="ruleForm.beizhu" placeholder="备注" clearable  :readonly="ro.beizhu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="备注" prop="beizhu" >
					<el-input v-model="ruleForm.beizhu" placeholder="备注" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'" label="学号" prop="xuehao" >
					<el-select :disabled="ro.xuehao" @change="xuehaoChange" v-model="ruleForm.xuehao" placeholder="请选择学号">
						<el-option
							v-for="(item,index) in xuehaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.xuehao" label="学号" prop="xuehao" >
					<el-input v-model="ruleForm.xuehao" placeholder="学号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="学生姓名" prop="xueshengxingming" >
					<el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名" clearable  :readonly="ro.xueshengxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="学生姓名" prop="xueshengxingming" >
					<el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="家长账号" prop="jiazhangzhanghao" >
					<el-input v-model="ruleForm.jiazhangzhanghao" placeholder="家长账号" clearable  :readonly="ro.jiazhangzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="家长账号" prop="jiazhangzhanghao" >
					<el-input v-model="ruleForm.jiazhangzhanghao" placeholder="家长账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="家长姓名" prop="jiazhangxingming" >
					<el-input v-model="ruleForm.jiazhangxingming" placeholder="家长姓名" clearable  :readonly="ro.jiazhangxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="家长姓名" prop="jiazhangxingming" >
					<el-input v-model="ruleForm.jiazhangxingming" placeholder="家长姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="服务状态" prop="fuwuzhuangtai" >
					<el-select :disabled="ro.fuwuzhuangtai" v-model="ruleForm.fuwuzhuangtai" placeholder="请选择服务状态" >
						<el-option
							v-for="(item,index) in fuwuzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="服务状态" prop="fuwuzhuangtai" >
					<el-input v-model="ruleForm.fuwuzhuangtai"
						placeholder="服务状态" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					yuyuebianhao : false,
					kechengmingcheng : false,
					fengmian : false,
					jiajiaozhanghao : false,
					jiajiaoxingming : false,
					xiaoshijiage : false,
					yuyueshijian : false,
					yuyueshizhang : false,
					yuyuedizhi : false,
					zongjine : false,
					beizhu : false,
					xuehao : false,
					xueshengxingming : false,
					jiazhangzhanghao : false,
					jiazhangxingming : false,
					lianxidianhua : false,
					fuwuzhuangtai : false,
					sfsh : false,
					shhf : false,
					ispay : false,
					userid : false,
				},
			
				ruleForm: {
					yuyuebianhao: this.getUUID(),
					kechengmingcheng: '',
					fengmian: '',
					jiajiaozhanghao: '',
					jiajiaoxingming: '',
					xiaoshijiage: '',
					yuyueshijian: '',
					yuyueshizhang: '',
					yuyuedizhi: '',
					zongjine: '',
					beizhu: '',
					xuehao: '',
					xueshengxingming: '',
					jiazhangzhanghao: '',
					jiazhangxingming: '',
					lianxidianhua: '',
					fuwuzhuangtai: '未学习',
					shhf: '',
					userid: '',
				},
		
				xuehaoOptions: [],
				fuwuzhuangtaiOptions: [],

				rules: {
					yuyuebianhao: [
					],
					kechengmingcheng: [
					],
					fengmian: [
					],
					jiajiaozhanghao: [
					],
					jiajiaoxingming: [
					],
					xiaoshijiage: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					yuyueshijian: [
					],
					yuyueshizhang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					yuyuedizhi: [
					],
					zongjine: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					beizhu: [
					],
					xuehao: [
					],
					xueshengxingming: [
					],
					jiazhangzhanghao: [
					],
					jiazhangxingming: [
					],
					lianxidianhua: [
					],
					fuwuzhuangtai: [
					],
					sfsh: [
					],
					shhf: [
					],
					ispay: [
					],
					userid: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {


			zongjine:{
				get: function () {
					return 1*this.ruleForm.xiaoshijiage*this.ruleForm.yuyueshizhang
				}
			},

		},
		components: {
		},
		created() {
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'){
					this.info(id);
				}else if(this.type=='logistics'){
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='yuyuebianhao'){
							this.ruleForm.yuyuebianhao = obj[o];
							this.ro.yuyuebianhao = true;
							continue;
						}
						if(o=='kechengmingcheng'){
							this.ruleForm.kechengmingcheng = obj[o];
							this.ro.kechengmingcheng = true;
							continue;
						}
						if(o=='fengmian'){
							this.ruleForm.fengmian = obj[o];
							this.ro.fengmian = true;
							continue;
						}
						if(o=='jiajiaozhanghao'){
							this.ruleForm.jiajiaozhanghao = obj[o];
							this.ro.jiajiaozhanghao = true;
							continue;
						}
						if(o=='jiajiaoxingming'){
							this.ruleForm.jiajiaoxingming = obj[o];
							this.ro.jiajiaoxingming = true;
							continue;
						}
						if(o=='xiaoshijiage'){
							this.ruleForm.xiaoshijiage = obj[o];
							this.ro.xiaoshijiage = true;
							continue;
						}
						if(o=='yuyueshijian'){
							this.ruleForm.yuyueshijian = obj[o];
							this.ro.yuyueshijian = true;
							continue;
						}
						if(o=='yuyueshizhang'){
							this.ruleForm.yuyueshizhang = obj[o];
							this.ro.yuyueshizhang = true;
							continue;
						}
						if(o=='yuyuedizhi'){
							this.ruleForm.yuyuedizhi = obj[o];
							this.ro.yuyuedizhi = true;
							continue;
						}
						if(o=='zongjine'){
							this.ruleForm.zongjine = obj[o];
							this.ro.zongjine = true;
							continue;
						}
						if(o=='beizhu'){
							this.ruleForm.beizhu = obj[o];
							this.ro.beizhu = true;
							continue;
						}
						if(o=='xuehao'){
							this.ruleForm.xuehao = obj[o];
							this.ro.xuehao = true;
							continue;
						}
						if(o=='xueshengxingming'){
							this.ruleForm.xueshengxingming = obj[o];
							this.ro.xueshengxingming = true;
							continue;
						}
						if(o=='jiazhangzhanghao'){
							this.ruleForm.jiazhangzhanghao = obj[o];
							this.ro.jiazhangzhanghao = true;
							continue;
						}
						if(o=='jiazhangxingming'){
							this.ruleForm.jiazhangxingming = obj[o];
							this.ro.jiazhangxingming = true;
							continue;
						}
						if(o=='lianxidianhua'){
							this.ruleForm.lianxidianhua = obj[o];
							this.ro.lianxidianhua = true;
							continue;
						}
						if(o=='fuwuzhuangtai'){
							this.ruleForm.fuwuzhuangtai = obj[o];
							this.ro.fuwuzhuangtai = true;
							continue;
						}
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
							continue;
						}
					}
					this.ruleForm.fuwuzhuangtai = '未学习'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.jiazhangzhanghao!=''&&json.jiazhangzhanghao) || json.jiazhangzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.jiazhangzhanghao = json.jiazhangzhanghao
							this.ro.jiazhangzhanghao = true;
						}
						if(((json.jiazhangxingming!=''&&json.jiazhangxingming) || json.jiazhangxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.jiazhangxingming = json.jiazhangxingming
							this.ro.jiazhangxingming = true;
						}
						if(((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.lianxidianhua = json.lianxidianhua
							this.ro.lianxidianhua = true;
						}
						if(this.$storage.get("role")!="管理员") {
							this.ro.fuwuzhuangtai = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/xuesheng/xuehao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.xuehaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.fuwuzhuangtaiOptions = "已学习,未学习".split(',')
			
			},
			// 下二随
			xuehaoChange () {
				this.$http({
					url: `follow/xuesheng/xuehao?columnValue=`+ this.ruleForm.xuehao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.xueshengxingming){
							this.ruleForm.xueshengxingming = data.data.xueshengxingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `jiajiaoyuyue/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.ispay = '未支付'
					if(this.ruleForm.yuyuebianhao) {
						this.ruleForm.yuyuebianhao = String(this.ruleForm.yuyuebianhao)
					}
					this.ruleForm.zongjine = this.zongjine
					if(this.ruleForm.fengmian!=null) {
						this.ruleForm.fengmian = this.ruleForm.fengmian.replace(new RegExp(this.$base.url,"g"),"");
					}
var objcross = this.$storage.getObj('crossObj');
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `jiajiaoyuyue/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.jiajiaoyuyueCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.jiajiaoyuyueCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			fengmianUploadChange(fileUrls) {
				this.ruleForm.fengmian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
		background: none;
		width: 100%;
	}
	.add-update-preview {
		border-radius: 10px;
		padding: 40px 30px;
		background: #ffffff;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 49%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #6e6e6e;
		font-weight: 500;
		width: 180px;
		font-size: 15px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 15px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: auto;
		font-size: 15px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 15px;
		min-height: 150px;
		height: auto;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: auto;
				font-size: 15px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #0356bb;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #39c9ee;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #6ea0dc;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #4abcff;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 6px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #0977fd;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
