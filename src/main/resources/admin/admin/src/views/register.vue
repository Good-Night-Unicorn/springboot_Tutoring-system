<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="rgsForm" class="rgs-form animate__animated animate__" :model="rgsForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">家教系统设计与实现</div>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('xuehao')?'required':''">学号：</div>
						<el-input  v-model="ruleForm.xuehao"  autocomplete="off" placeholder="学号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('xueshengxingming')?'required':''">学生姓名：</div>
						<el-input  v-model="ruleForm.xueshengxingming"  autocomplete="off" placeholder="学生姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="xueshengtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in xueshengxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input  v-model="ruleForm.shoujihaoma"  autocomplete="off" placeholder="手机号码"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('jiazhangzhanghao')?'required':''">家长账号：</div>
						<el-select @change="xueshengjiazhangzhanghaoChange" v-model="ruleForm.jiazhangzhanghao" placeholder="请选择家长账号" >
							<el-option
								v-for="(item,index) in xueshengjiazhangzhanghaoOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='xuesheng'">
						<div class="lable" :class="changeRules('jiazhangxingming')?'required':''">家长姓名：</div>
						<el-input  v-model="ruleForm.jiazhangxingming" readonly autocomplete="off" placeholder="家长姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('jiazhangzhanghao')?'required':''">家长账号：</div>
						<el-input  v-model="ruleForm.jiazhangzhanghao"  autocomplete="off" placeholder="家长账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('jiazhangxingming')?'required':''">家长姓名：</div>
						<el-input  v-model="ruleForm.jiazhangxingming"  autocomplete="off" placeholder="家长姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jiazhangtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in jiazhangxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiazhang'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('jiajiaozhanghao')?'required':''">家教账号：</div>
						<el-input  v-model="ruleForm.jiajiaozhanghao"  autocomplete="off" placeholder="家教账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jiajiaotouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('jiajiaoxingming')?'required':''">家教姓名：</div>
						<el-input  v-model="ruleForm.jiajiaoxingming"  autocomplete="off" placeholder="家教姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in jiajiaoxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
						<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="联系电话"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiajiao'">
						<div class="lable" :class="changeRules('jiajiaozizhi')?'required':''">家教资质：</div>
						<file-upload
							tip="点击上传家教资质"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.jiajiaozizhi?ruleForm.jiajiaozizhi:''"
							@change="jiajiaojiajiaozizhiUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，点击登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            xueshengxingbieOptions: [],
            xueshengjiazhangzhanghaoOptions: [],
            jiazhangxingbieOptions: [],
            jiajiaoxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='xuesheng'){
				this.ruleForm = {
					xuehao: '',
					mima: '',
					xueshengxingming: '',
					touxiang: '',
					xingbie: '',
					shoujihaoma: '',
					jiazhangzhanghao: '',
					jiazhangxingming: '',
				}
			}
			if(this.tableName=='jiazhang'){
				this.ruleForm = {
					jiazhangzhanghao: '',
					mima: '',
					jiazhangxingming: '',
					touxiang: '',
					xingbie: '',
					lianxidianhua: '',
				}
			}
			if(this.tableName=='jiajiao'){
				this.ruleForm = {
					jiajiaozhanghao: '',
					mima: '',
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
				this.rules.xuehao = [{ required: true, message: '请输入学号', trigger: 'blur' }]
			}
			if ('xuesheng' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('xuesheng' == this.tableName) {
				this.rules.xueshengxingming = [{ required: true, message: '请输入学生姓名', trigger: 'blur' }]
			}
			if ('jiazhang' == this.tableName) {
				this.rules.jiazhangzhanghao = [{ required: true, message: '请输入家长账号', trigger: 'blur' }]
			}
			if ('jiazhang' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiazhang' == this.tableName) {
				this.rules.jiazhangxingming = [{ required: true, message: '请输入家长姓名', trigger: 'blur' }]
			}
			if ('jiajiao' == this.tableName) {
				this.rules.jiajiaozhanghao = [{ required: true, message: '请输入家教账号', trigger: 'blur' }]
			}
			if ('jiajiao' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiajiao' == this.tableName) {
				this.rules.jiajiaozizhi = [{ required: true, message: '请输入家教资质', trigger: 'blur' }]
			}
			this.xueshengxingbieOptions = "男,女".split(',')
			this.$http({
				url: `option/jiazhang/jiazhangzhanghao`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.xueshengjiazhangzhanghaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.jiazhangxingbieOptions = "男,女".split(',')
			this.jiajiaoxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        xueshengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        // 下二随
        xueshengjiazhangzhanghaoChange () {
            this.$http({
                url: `follow/jiazhang/jiazhangzhanghao?columnValue=`+ this.ruleForm.jiazhangzhanghao,
                method: "get"
            }).then(({ data }) => {
                if (data && data.code === 0) {
                    if(data.data.jiazhangxingming){
                        this.ruleForm.jiazhangxingming = data.data.jiazhangxingming
                    }
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
        jiazhangtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiajiaotouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiajiaojiajiaozizhiUploadChange(fileUrls) {
            this.ruleForm.jiajiaozizhi = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
				this.$message.error(`学号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `xuesheng` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.xueshengxingming) && `xuesheng` == this.tableName){
				this.$message.error(`学生姓名不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`xuesheng` == this.tableName && this.ruleForm.shoujihaoma &&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
				this.$message.error(`手机号码应输入手机格式`);
				return
			}
			if((!this.ruleForm.jiazhangzhanghao) && `jiazhang` == this.tableName){
				this.$message.error(`家长账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jiazhang` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiazhang` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.jiazhangxingming) && `jiazhang` == this.tableName){
				this.$message.error(`家长姓名不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`jiazhang` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
			  if(this.tableName=='jiajiao'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.jiajiaozhanghao) && `jiajiao` == this.tableName){
				this.$message.error(`家教账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jiajiao` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiajiao` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`jiajiao` == this.tableName && this.ruleForm.lianxidianhua &&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}
            if(this.ruleForm.jiajiaozizhi!=null) {
                this.ruleForm.jiajiaozizhi = this.ruleForm.jiajiaozizhi.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.jiajiaozizhi) && `jiajiao` == this.tableName){
				this.$message.error(`家教资质不能为空`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240920/478d9d0cf9214f75a492b100481872a4.jpg) no-repeat center center / 100% 100%;
	background: url(http://codegen.caihongy.cn/20240920/478d9d0cf9214f75a492b100481872a4.jpg) no-repeat center center / 100% 100%;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	position: relative !important;
	.rgs-form {
		.rgs-form2 {
		width: 100%;
		}
		border-radius: 0px;
		padding: 30px 80px 30px 130px;
		margin: 30px auto;
		background: #ffffff;
		width: 600px;
		height: auto;
		.title {
			padding: 0;
			margin: 0 0 20px 0;
			color: #0674fc;
			background: none;
			font-weight: 600;
			width: auto;
			font-size: 26px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			width: 100%;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
			}
			.lable {
				padding: 0 10px 0 0;
				color: #333;
				left: -130px;
				background: none;
				width: auto;
				font-size: 16px;
				line-height: 34px;
				position: absolute !important;
				text-align: right;
				min-width: 130px;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #0674fc;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 40px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0px;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 40px;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px 0 30px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			.el-date-editor.el-input {
				width: 100%;
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
				border: 1px solid #0674fc;
				cursor: pointer;
				border-radius: 0;
				color: #0674fc;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #0674fc;
				cursor: pointer;
				border-radius: 0;
				color: #0674fc;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #0674fc;
				cursor: pointer;
				border-radius: 0;
				color: #0674fc;
				background: none;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #666;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				top: 5px;
				left: 118px;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				margin: 0;
				color: #666;
				background: none;
				flex: 1;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			input:focus {
				border: 1px solid #0674fc;
				border-radius: 0;
				padding: 0 10px;
				outline: none;
				color: #666;
				background: none;
				width: 100%;
				font-size: 15px;
				height: 38px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 0px solid #e6e6e6;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 0 0 10px;
				color: #fff;
				background: #0674fc;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.9;
			}
		}
		.register-btn {
			display: flex;
			width: 100%;
			flex-wrap: wrap;
		}
		.register-btn1 {
			width: 100%;
			order: 2;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			font-weight: 600;
			letter-spacing: 10px;
			font-size: 22px;
			border-radius: 0;
			background: #0674fc;
			width: 100%;
			min-width: 68px;
			height: 50px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.9;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #999;
			display: inline-block;
			width: 100%;
			font-size: 15px;
			line-height: 50px;
			text-align: right;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
