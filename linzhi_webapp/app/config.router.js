'use strict';
angular.module('app')
    .run(
        [
            '$rootScope', '$state', '$stateParams',
            function($rootScope, $state, $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }
        ]
    )
    .config(
        [
            '$stateProvider', '$urlRouterProvider',
            function($stateProvider, $urlRouterProvider) {

                $urlRouterProvider
                    .otherwise('/login');
                $stateProvider
                    .state('app', {
                        abstract: true,
                        url: '/app',
                        templateUrl: 'views/layout.html'
                    })
                    .state('app.dashboard', {
                        url: '/dashboard',
                        templateUrl: 'views/dashboard.html',
                        // ncyBreadcrumb: {
                        //     label: 'Dashboard',
                        //     description: ''
                        // },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'lib/jquery/charts/sparkline/jquery.sparkline.js',
                                            'lib/jquery/charts/easypiechart/jquery.easypiechart.js',
                                            'lib/jquery/charts/flot/jquery.flot.js',
                                            'lib/jquery/charts/flot/jquery.flot.resize.js',
                                            'lib/jquery/charts/flot/jquery.flot.pie.js',
                                            'lib/jquery/charts/flot/jquery.flot.tooltip.js',
                                            'lib/jquery/charts/flot/jquery.flot.orderBars.js',
                                            'app/controllers/dashboard.js',
                                            'app/directives/realtimechart.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('app.userList', {
                        url: '/userList',
                        templateUrl: 'views/userList.html',
                        ncyBreadcrumb: {
                            label: '用户列表'
                        },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'app/controllers/userList.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('app.addUser', {
                        url: '/addUser',
                        templateUrl: 'views/addUser.html',
                        ncyBreadcrumb: {
                            label: '新增用户'
                        },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'app/controllers/addUser.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('app.editProject', {
                        url: '/editProject?:projectId',
                        templateUrl: 'views/editProject.html',
                        ncyBreadcrumb: {
                            label: '项目编辑'
                        },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'app/controllers/editProject.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('app.createProject', {
                        url: '/createProject',
                        templateUrl: 'views/createProject.html',
                        ncyBreadcrumb: {
                            label: '项目创建'
                        },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'app/controllers/createProject.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('app.projectList', {
                        url: '/projectList',
                        templateUrl: 'views/projectList.html',
                        ncyBreadcrumb: {
                            label: '项目列表'
                        },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'app/controllers/projectList.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('login', {
                        url: '/login',
                        templateUrl: 'views/login.html',
                        ncyBreadcrumb: {
                            label: 'Login'
                        },
                        resolve: {
                            deps: [
                                '$ocLazyLoad',
                                function($ocLazyLoad) {
                                    return $ocLazyLoad.load({
                                        serie: true,
                                        files: [
                                            'app/controllers/login.js'
                                        ]
                                    });
                                }
                            ]
                        }
                    })
                    .state('register', {
                        url: '/register',
                        templateUrl: 'views/register.html',
                        ncyBreadcrumb: {
                            label: 'Register'
                        }
                    })
                    .state('lock', {
                        url: '/lock',
                        templateUrl: 'views/lock.html',
                        ncyBreadcrumb: {
                            label: 'Lock Screen'
                        }
                    })
                    .state('error404', {
                        url: '/error404',
                        templateUrl: 'views/error-404.html',
                        ncyBreadcrumb: {
                            label: 'Error 404 - The page not found'
                        }
                    })
                    .state('error500', {
                        url: '/error500',
                        templateUrl: 'views/error-500.html',
                        ncyBreadcrumb: {
                            label: 'Error 500 - something went wrong'
                        }
                    })
                    ;
            }
        ]
    );