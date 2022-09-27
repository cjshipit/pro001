# CSS 的书写位置
1 可以内联 写死在标签上面
  不够灵活
  ```html
  <p style="color:red;">这是一句诗歌</p>
  ```
2 内部样式 写在style文件中
   还好一点 但是还是有
   ```css
    <style>
        p{
            color: red;
            font-size: 30;
        }
    </style>
   ```
3 外部引用 单独写一个文件 然后link 引入
  该方法最好 然后可以缓存 可以跨文件使用
  ```
  <link rel="stylesheet" href="">
  ```

  # css的注释 和C语言一样不同于html style中的内容