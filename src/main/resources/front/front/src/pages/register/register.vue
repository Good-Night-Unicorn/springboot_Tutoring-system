<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">家教系统设计与实现</p></div>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="xuehao">
						<div class="label" :class="changeRules('xuehao')?'required':''">学号：</div>
						<el-input v-model="registerForm.xuehao"  placeholder="请输入学号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="xueshengxingming">
						<div class="label" :class="changeRules('xueshengxingming')?'required':''">学生姓名：</div>
						<el-input v-model="registerForm.xueshengxingming"  placeholder="请输入学生姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="xueshengtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in xueshengxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="shoujihaoma">
						<div class="label" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input v-model="registerForm.shoujihaoma"  placeholder="请输入手机号码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="jiazhangzhanghao">
						<div class="label" :class="changeRules('jiazhangzhanghao')?'required':''">家长账号：</div>
						<el-select @change="xueshengjiazhangzhanghaoChange" v-model="registerForm.jiazhangzhanghao" placeholder="请选择家长账号" >
							<el-option
								v-for="(item,index) in xueshengjiazhangzhanghaoOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'" prop="jiazhangxingming">
						<div class="label" :class="changeRules('jiazhangxingming')?'required':''">家长姓名：</div>
						<el-input v-model="registerForm.jiazhangxingming" readonly placeholder="请输入家长姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="jiazhangzhanghao">
						<div class="label" :class="changeRules('jiazhangzhanghao')?'required':''">家长账号：</div>
						<el-input v-model="registerForm.jiazhangzhanghao"  placeholder="请输入家长账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="jiazhangxingming">
						<div class="label" :class="changeRules('jiazhangxingming')?'required':''">家长姓名：</div>
						<el-input v-model="registerForm.jiazhangxingming"  placeholder="请输入家长姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="jiazhangtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in jiazhangxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'" prop="lianxidianhua">
						<div class="label" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="jiajiaozhanghao">
						<div class="label" :class="changeRules('jiajiaozhanghao')?'required':''">家教账号：</div>
						<el-input v-model="registerForm.jiajiaozhanghao"  placeholder="请输入家教账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="jiajiaotouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="jiajiaoxingming">
						<div class="label" :class="changeRules('jiajiaoxingming')?'required':''">家教姓名：</div>
						<el-input v-model="registerForm.jiajiaoxingming"  placeholder="请输入家教姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in jiajiaoxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="lianxidianhua">
						<div class="label" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'" prop="jiajiaozizhi">
						<div class="label" :class="changeRules('jiajiaozizhi')?'required':''">家教资质：</div>
						<file-upload
							tip="点击上传家教资质"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.jiajiaozizhi?registerForm.jiajiaozizhi:''"
							@change="jiajiaojiajiaozizhiUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            xueshengxingbieOptions: [],
            xueshengjiazhangzhanghaoOptions: [],
            jiazhangxingbieOptions: [],
            jiajiaoxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='xuesheng'){
				this.registerForm = {
					xuehao: '',
					mima: '',
					mima2: '',
					xueshengxingming: '',
					touxiang: '',
					xingbie: '',
					shoujihaoma: '',
					jiazhangzhanghao: '',
					jiazhangxingming: '',
				}
			}
			if(this.tableName=='jiazhang'){
				this.registerForm = {
					jiazhangzhanghao: '',
					mima: '',
					mima2: '',
					jiazhangxingming: '',
					touxiang: '',
					xingbie: '',
					lianxidianhua: '',
				}
			}
			if(this.tableName=='jiajiao'){
				this.registerForm = {
					jiajiaozhanghao: '',
					mima: '',
					mima2: '',
					touxiang: '',
					jiajiaoxingming: '',
					xingbie: '',
					lianxidianhua: '',
					jiajiaozizhi: '',
					sfsh: '',
					shhf: '',
				}
			}
			if ('xuesheng' == this.tableName) {
				this.rules.xuehao = [{ required: true, message: '请输入学号', trigger: 'blur' }];
				this.requiredRules.xuehao = [{ required: true, message: '请输入学号', trigger: 'blur' }]
			}
			if ('xuesheng' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('xuesheng' == this.tableName) {
				this.rules.xueshengxingming = [{ required: true, message: '请输入学生姓名', trigger: 'blur' }];
				this.requiredRules.xueshengxingming = [{ required: true, message: '请输入学生姓名', trigger: 'blur' }]
			}
			this.xueshengxingbieOptions = "男,女".split(',');
			if ('xuesheng' == this.tableName) {
				this.rules.shoujihaoma = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			this.$http({
				url: `option/jiazhang/jiazhangzhanghao`,
				method: "get",
				params: {}
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.xueshengjiazhangzhanghaoOptions = data.data;
				}
			});
			if ('jiazhang' == this.tableName) {
				this.rules.jiazhangzhanghao = [{ required: true, message: '请输入家长账号', trigger: 'blur' }];
				this.requiredRules.jiazhangzhanghao = [{ required: true, message: '请输入家长账号', trigger: 'blur' }]
			}
			if ('jiazhang' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiazhang' == this.tableName) {
				this.rules.jiazhangxingming = [{ required: true, message: '请输入家长姓名', trigger: 'blur' }];
				this.requiredRules.jiazhangxingming = [{ required: true, message: '请输入家长姓名', trigger: 'blur' }]
			}
			this.jiazhangxingbieOptions = "男,女".split(',');
			if ('jiazhang' == this.tableName) {
				this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('jiajiao' == this.tableName) {
				this.rules.jiajiaozhanghao = [{ required: true, message: '请输入家教账号', trigger: 'blur' }];
				this.requiredRules.jiajiaozhanghao = [{ required: true, message: '请输入家教账号', trigger: 'blur' }]
			}
			if ('jiajiao' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.jiajiaoxingbieOptions = "男,女".split(',');
			if ('jiajiao' == this.tableName) {
				this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('jiajiao' == this.tableName) {
				this.rules.jiajiaozizhi = [{ required: true, message: '请输入家教资质', trigger: 'blur' }];
				this.requiredRules.jiajiaozizhi = [{ required: true, message: '请输入家教资质', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		xueshengtouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
        xueshengjiazhangzhanghaoChange () {
			this.$http({
				url: `follow/jiazhang/jiazhangzhanghao?columnValue=`+ this.registerForm.jiazhangzhanghao,
				method: "get",
				params: {}
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(data.data.jiazhangxingming){
						this.registerForm.jiazhangxingming = data.data.jiazhangxingming
					}
				}
			});
        },
		jiazhangtouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		jiajiaotouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		jiajiaojiajiaozizhiUploadChange(fileUrls) {
			this.registerForm.jiajiaozizhi = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(`xuesheng` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(`jiazhang` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(this.tableName=='jiajiao'){
						this.registerForm.sfsh = '待审核'
					}
					if(`jiajiao` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background-repeat: no-repeat;
		background-size: 100% 100%!important;
		background: url(http://codegen.caihongy.cn/20240919/6ea62b3c9bbb4010b3c8a88b1efb2c49.jpg);
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		background-position: center center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20240919/6ea62b3c9bbb4010b3c8a88b1efb2c49.jpg);
		.rgs-form {
			padding: 0;
			margin: 0;
			z-index: 10;
			background: url(http://codegen.caihongy.cn/20240919/90ac7a10493f4a16a17240e89dec668a.png) no-repeat center center / 100% 100%;
			display: flex;
			width: 100%;
			min-height: 100vh;
			justify-content: flex-start;
			align-items: center;
			height: auto;
			.rgs-form2 {
				padding: 0;
				margin: 0 0 0 10%;
				background: #fff;
				width: 550px;
				.title {
					margin: 0 0 20px 0;
					color: #333;
					width: 100%;
					font-size: 24px;
					line-height: 44px;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					margin: 0 auto 25px;
					width: 100%;
					/deep/.el-form-item__content {
						display: flex;
						width: 100%;
						.label {
							color: #333;
							width: 120px;
							font-size: 16px;
							line-height: 40px;
							text-align: right;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							margin: 0 10px 0 0;
							color: red;
							left: 0px;
							position: inherit;
							content: "*";
						}
						.el-input {
							flex: 1;
							width: 100%;
						}
						.el-input /deep/ .el-input__inner {
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-input /deep/ .el-input__inner:focus {
							border: 1px solid #f7db61;
							border-radius: 0;
							padding: 0 10px;
							outline: none;
							color: #666;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-select {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-select /deep/ .el-input__inner {
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-select /deep/ .el-input__inner:focus {
							border: 1px solid #f7db61;
							border-radius: 0;
							padding: 0 10px;
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-date-editor {
							flex: 1;
							width: calc(100% - 0px);
						}
						.el-date-editor /deep/ .el-input__inner {
							border: 1px solid #ddd;
							border-radius: 0;
							padding: 0 10px 0 30px;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-date-editor /deep/ .el-input__inner:focus {
							border: 1px solid #f7db61;
							border-radius: 0;
							padding: 0 10px 0 30px;
							outline: none;
							color: #666;
							width: 100%;
							font-size: 15px;
							height: 40px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							color: #999;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 80px;
							text-align: center;
							height: 80px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							color: #999;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 80px;
							text-align: center;
							height: 80px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							color: #999;
							background: #fff;
							width: 80px;
							font-size: 24px;
							line-height: 80px;
							text-align: center;
							height: 80px;
						}
						.el-upload__tip {
							color: #666;
							font-size: 15px;
						}
						.emailInput {
							border: 1px solid #ddd;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							margin: 0;
							color: #606266;
							background: #fff;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.emailInput:focus {
							border: 1px solid #f7db61;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							outline: none;
							color: #606266;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-btn {
							border: 1px solid #ddd;
							border-radius: 0px 0 0 0px;
							padding: 0 10px;
							margin: 0;
							color: #606266;
							background: #fff;
							flex: 1;
							width: calc(100% - 0px);
							font-size: 15px;
							height: 40px;
						}
						.el-btn:hover {
						}
						
						/deep/ .el-input__inner::placeholder {
							color: #999;
							font-size: 15px;
						}
						input::placeholder {
							color: #999;
							font-size: 15px;
						}
						.editor {
							margin: 0 0 0 120px;
							background: #fff;
							width: calc(100% - 120px);
							height: auto;
						}
					}
				}
				.register-btn {
					margin: 20px auto;
					width: 100%;
				}
				.register-btn1 {
					padding: 0 0 0 120px;
					width: 100%;
				}
				.register-btn2 {
					padding: 0 0 0 120px;
					margin: 10px auto;
					width: 100%;
					text-align: right;
				}
				.register_btn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 30px;
					margin: 0 0px;
					color: #fff;
					background: #03abe9;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.register_btn:hover {
					opacity: 0.8;
				}
				.has_btn {
					cursor: pointer;
					padding: 0;
					color: #555;
					display: inline-block;
					text-decoration: none;
					font-size: 15px;
					line-height: 40px;
				}
				.has_btn:hover {
					opacity: 0.8;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
</style>
