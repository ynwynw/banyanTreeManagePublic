const config = {
  get() {
    return {
      url:
        process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
      name: process.env.VUE_APP_BASE_API,
      menuList: [
        {
          name: '古树信息管理',
          icon: '${frontMenu.fontClass}',
          child: [
            {
              name: '古树信息',
              url: '/index/rongshuxinxiList',
            },
          ],
        },
        {
          name: '古树资源管理',
          icon: '${frontMenu.fontClass}',
          child: [
            {
              name: '古树资源',
              url: '/index/rongshuziyuanList',
            },
          ],
        },
        {
          name: '新闻资讯管理',
          icon: '${frontMenu.fontClass}',
          child: [
            {
              name: '新闻资讯',
              url: '/index/newsList',
            },
          ],
        },
      ],
    }
  },
  getProjectName() {
    return {
      projectName: '基于Springboot的古树管理系统',
    }
  },
}
export default config
