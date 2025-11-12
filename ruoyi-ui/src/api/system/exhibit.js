import request from '@/utils/request'

// 查询展品列表
export function listExhibit(query) {
  return request({
    url: '/system/exhibit/list',
    method: 'get',
    params: query
  })
}

// 查询展品详细
export function getExhibit(id) {
  return request({
    url: '/system/exhibit/' + id,
    method: 'get'
  })
}

// 新增展品
export function addExhibit(data) {
  return request({
    url: '/system/exhibit',
    method: 'post',
    data: data
  })
}

// 修改展品
export function updateExhibit(data) {
  return request({
    url: '/system/exhibit',
    method: 'put',
    data: data
  })
}

// 删除展品
export function delExhibit(id) {
  return request({
    url: '/system/exhibit/' + id,
    method: 'delete'
  })
}
