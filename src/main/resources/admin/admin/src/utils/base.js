const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot484n4tm2/",
            name: "springboot484n4tm2",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot484n4tm2/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "家教系统设计与实现"
        } 
    }
}
export default base
