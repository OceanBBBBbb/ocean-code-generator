import request from '@/utils/request'

export function add(data) {
    return request({
        url: 'api/oceanGenTest',
        method: 'post',
        data
    })
}

export function del(id) {
    return request({
        url: 'api/oceanGenTest/' + id,
        method: 'delete'
    })
}

export function edit(data) {
    return request({
        url: 'api/oceanGenTest',
        method: 'put',
        data
    })
}
