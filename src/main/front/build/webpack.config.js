'use strict'
const webpack = require('webpack')
const { VueLoaderPlugin } = require('vue-loader')
const HtmlWebpackPlugin = require('html-webpack-plugin')
module.exports = {
    mode: 'development',

    entry: {
        app: ['./src/app.js'],
    },
    devServer: {
        hot: true,
        watchOptions: {
            poll: true
        }
    },
    module: {
        rules: [
            {
                test: /\.vue$/,
                use: 'vue-loader'
            },
            {
                test: /\.css$/,
                use: [
                    'vue-style-loader',
                    'css-loader'
                ]
            },
            {
                test: /\.js$/,
                use: 'babel-loader'
            }
        ]
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new VueLoaderPlugin(),
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'index.html',
            inject: true
        }),
        new webpack.DefinePlugin({
            APP_LOCAL_API_URL : JSON.stringify("http://localhost:8080/api")
        })
    ],
    devServer: {
        port: 3000,
        proxy: {
            '/api/': {
                target: 'http://localhost:8080/api', // 개발서버
                pathRewrite: {'^/api': ''},
                changeOrigin:true
            }
        }
    }
}
