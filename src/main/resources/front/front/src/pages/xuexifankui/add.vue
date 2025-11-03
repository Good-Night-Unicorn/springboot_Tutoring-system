<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="预约编号" prop="yuyuebianhao">
				<el-input v-model="ruleForm.yuyuebianhao" 
					placeholder="预约编号" clearable :disabled=" false  ||ro.yuyuebianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="课程名称" prop="kechengmingcheng">
				<el-input v-model="ruleForm.kechengmingcheng" 
					placeholder="课程名称" clearable :disabled=" false  ||ro.kechengmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="封面" v-if="type!='cross' || (type=='cross' && !ro.fengmian)" prop="fengmian">
				<file-upload
					tip="点击上传封面"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
					@change="fengmianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="封面" prop="fengmian">
				<img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="家教账号" prop="jiajiaozhanghao">
				<el-input v-model="ruleForm.jiajiaozhanghao" 
					placeholder="家教账号" clearable :disabled=" false  ||ro.jiajiaozhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="家教姓名" prop="jiajiaoxingming">
				<el-input v-model="ruleForm.jiajiaoxingming" 
					placeholder="家教姓名" clearable :disabled=" false  ||ro.jiajiaoxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="学习视频" v-if="type!='cross' || (type=='cross' && !ro.xuexishipin)" prop="xuexishipin">
				<file-upload
					tip="点击上传学习视频"
					action="file/upload"
					:limit="1"
					:type="2"
					:multiple="true"
					:fileUrls="ruleForm.xuexishipin?ruleForm.xuexishipin:''"
					@change="xuexishipinUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="学习视频" prop="xuexishipin">
				<div class="viewBtn" v-if="ruleForm.xuexishipin" @click="download(baseUrl + ruleForm.xuexishipin)" type="success">预览</div>
				<div class="unviewBtn" v-else disabled>暂无</div>
			</el-form-item>
			<el-form-item class="add-item" label="教学资料" prop="jiaoxueziliao">
				<file-upload
					tip="点击上传教学资料"
					action="file/upload"
					:limit="1"
					:type="3"
					:multiple="true"
					:fileUrls="ruleForm.jiaoxueziliao?ruleForm.jiaoxueziliao:''"
					@change="jiaoxueziliaoUploadChange"
					></file-upload>
			</el-form-item>  
			<el-form-item class="add-item" label="记录时间" prop="jilushijian">
				<el-date-picker
					:disabled=" false  ||ro.jilushijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.jilushijian" 
					type="datetime"
					placeholder="记录时间">
				</el-date-picker>
			</el-form-item>
			<el-form-item class="add-item" label="备注" prop="xuexibeizhu">
				<el-input v-model="ruleForm.xuexibeizhu" 
					placeholder="备注" clearable :disabled=" false  ||ro.xuexibeizhu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="学号" prop="xuehao">
				<el-select  @change="xuehaoChange" v-model="ruleForm.xuehao" placeholder="请选择学号">
					<el-option
						v-for="(item,index) in xuehaoOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="学生姓名" prop="xueshengxingming">
				<el-input v-model="ruleForm.xueshengxingming" 
					placeholder="学生姓名" clearable :disabled=" false  ||ro.xueshengxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="家长账号" prop="jiazhangzhanghao">
				<el-input v-model="ruleForm.jiazhangzhanghao" 
					placeholder="家长账号" clearable :disabled=" false  ||ro.jiazhangzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="家长姓名" prop="jiazhangxingming">
				<el-input v-model="ruleForm.jiazhangxingming" 
					placeholder="家长姓名" clearable :disabled=" false  ||ro.jiazhangxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="联系电话" prop="lianxidianhua">
				<el-input v-model="ruleForm.lianxidianhua" 
					placeholder="联系电话" clearable :disabled=" false  ||ro.lianxidianhua"></el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-kaitongfuwu"></span>
					<span class="text">更新信息</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu1"></span>
					<span class="text">退出登录</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					yuyuebianhao : false,
					kechengmingcheng : false,
					fengmian : false,
					jiajiaozhanghao : false,
					jiajiaoxingming : false,
					xuexishipin : false,
					jiaoxueziliao : false,
					jilushijian : false,
					xuexibeizhu : false,
					xuehao : false,
					xueshengxingming : false,
					jiazhangzhanghao : false,
					jiazhangxingming : false,
					lianxidianhua : false,
					userid : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					yuyuebianhao: '',
					kechengmingcheng: '',
					fengmian: '',
					jiajiaozhanghao: '',
					jiajiaoxingming: '',
					xuexishipin: '',
					jiaoxueziliao: '',
					jilushijian: '',
					xuexibeizhu: '',
					xuehao: '',
					xueshengxingming: '',
					jiazhangzhanghao: '',
					jiazhangxingming: '',
					lianxidianhua: '',
					userid: '',
				},
				xuehaoOptions: [],


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
					xuexishipin: [
						{ required: true, message: '学习视频不能为空', trigger: 'blur' },
					],
					jiaoxueziliao: [
						{ required: true, message: '教学资料不能为空', trigger: 'blur' },
					],
					jilushijian: [
					],
					xuexibeizhu: [
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
					userid: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.jilushijian = this.getCurDateTime()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
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
							this.ruleForm.fengmian = obj[o].split(",")[0];
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
						if(o=='xuexishipin'){
							this.ruleForm.xuexishipin = obj[o];
							this.ro.xuexishipin = true;
							continue;
						}
						if(o=='jiaoxueziliao'){
							this.ruleForm.jiaoxueziliao = obj[o];
							this.ro.jiaoxueziliao = true;
							continue;
						}
						if(o=='jilushijian'){
							this.ruleForm.jilushijian = obj[o];
							this.ro.jilushijian = true;
							continue;
						}
						if(o=='xuexibeizhu'){
							this.ruleForm.xuexibeizhu = obj[o];
							this.ro.xuexibeizhu = true;
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
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.jiazhangzhanghao!=''&&json.jiazhangzhanghao) || json.jiazhangzhanghao==0){
							this.ruleForm.jiazhangzhanghao = json.jiazhangzhanghao;
							this.ro.jiazhangzhanghao = true;
						}
						if((json.jiazhangxingming!=''&&json.jiazhangxingming) || json.jiazhangxingming==0){
							this.ruleForm.jiazhangxingming = json.jiazhangxingming;
							this.ro.jiazhangxingming = true;
						}
						if((json.lianxidianhua!=''&&json.lianxidianhua) || json.lianxidianhua==0){
							this.ruleForm.lianxidianhua = json.lianxidianhua;
							this.ro.lianxidianhua = true;
						}
					}
				});
				this.$http.get('option/xuesheng/xuehao', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.xuehaoOptions = res.data.data;
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},
			// 下二随
			xuehaoChange () {
				this.$http.get('follow/xuesheng/xuehao?columnValue=' + this.ruleForm.xuehao, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						if(res.data.data.xueshengxingming){
							this.ruleForm.xueshengxingming = res.data.data.xueshengxingming
						}
					}
				});
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`xuexifankui/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`xuexifankui/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
				this.$router.go(-1);
			},
			fengmianUploadChange(fileUrls) {
				this.ruleForm.fengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
			xuexishipinUploadChange(fileUrls) {
				this.ruleForm.xuexishipin = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
			jiaoxueziliaoUploadChange(fileUrls) {
				this.ruleForm.jiaoxueziliao = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				padding: 0 0 10px;
				margin: 0 0 10px;
				background: none;
				border-color: #ccc;
				border-width: 0 0 1px;
				border-style: dashed;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				/deep/ .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				/deep/ .upload .upload-img {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #03abe930;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 0px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
					background: #eee;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 2px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					background: #03abe9;
					display: inline-block;
					width: auto;
					font-size: 16px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					opacity: 0.8;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 0px solid #ddd;
					cursor: pointer;
					border-radius: 2px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					background: #03cce9;
					display: inline-block;
					width: auto;
					font-size: 16px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.closeBtn:hover {
					opacity: 0.8;
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
