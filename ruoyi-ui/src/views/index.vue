<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24" style="padding-left: 20px">
        <h2>观覆博物馆欢迎你</h2>
        <p>观覆博物馆是一家集收藏、研究、展示、教育于一体的综合性博物馆。馆藏丰富，涵盖古代文物、书画、陶瓷、青铜器、玉器等多个门类，总数超过10万件。</p>
           我们的使命是"让文物活起来"，通过创新的展览方式和教育项目，让更多人了解并热爱中华优秀传统文化。</p>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="24" :lg="24">
        <div class="museum-image-container">
          <!-- 修复图片引入方式 -->
          <img
            :src="imageUrl"
            alt="观覆博物馆展览展示"
            class="museum-show-image"
            @load="imageLoaded = true"
            @error="imageLoaded = false"
          >
          <div v-if="!imageLoaded" class="image-placeholder">
            <p>博物馆展览图片加载失败</p>
            <p>请检查图片路径：src/assets/images/show.jpg</p>
            <button @click="useFallbackImage" class="fallback-btn">使用备用图片</button>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
// 正确引入图片
import museumImage from '@/assets/images/show.jpg';

export default {
  name: "Index",
  data() {
    return {
      version: "3.9.0",
      imageLoaded: false,
      imageUrl: museumImage, // 使用导入的图片
      fallbackImage: 'https://images.unsplash.com/photo-1578662996442-48f60103fc96?ixlib=rb-4.0.3&auto=format&fit=crop&w=2000&q=80'
    }
  },
  mounted() {
    this.checkImageLoad();
  },
  methods: {
    checkImageLoad() {
      const img = new Image();
      img.onload = () => {
        this.imageLoaded = true;
      };
      img.onerror = () => {
        this.imageLoaded = false;
        console.error('图片加载失败，请检查路径:', this.imageUrl);
      };
      img.src = this.imageUrl;
    },
    useFallbackImage() {
      this.imageUrl = this.fallbackImage;
      this.imageLoaded = true;
    }
  }
}
</script>

<style scoped lang="scss">
.home {
  /* 原有样式保持不变 */
  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  /* ... 其他样式 */

  .museum-image-container {
    width: 100%;
    height: 60vh;
    overflow: hidden;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
    margin-top: 20px;
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #f5f5f5;
  }

  .museum-show-image {
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.3s ease;
  }

  .museum-show-image:hover {
    transform: scale(1.02);
  }

  .image-placeholder {
    text-align: center;
    color: #666;
    padding: 20px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);

    p {
      margin: 10px 0;
    }
  }

  .fallback-btn {
    margin-top: 10px;
    padding: 8px 16px;
    background-color: #8B4513;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  .fallback-btn:hover {
    background-color: #A0522D;
  }
}
</style>
