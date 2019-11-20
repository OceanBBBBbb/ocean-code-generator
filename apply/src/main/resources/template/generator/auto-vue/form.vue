<template>
  <el-dialog :append-to-body="true" :visible.sync="dialog" :title="isAdd ? '新增' : '编辑'" width="500px">
    <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
      <el-form-item label="前端api文件路径" >
        <el-input v-model="form.apiPath" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="作者" >
        <el-input v-model="form.author" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="是否覆盖" >
        <el-input v-model="form.cover" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="模块名" >
        <el-input v-model="form.moduleName" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="包路径" >
        <el-input v-model="form.pack" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="前端文件路径" >
        <el-input v-model="form.path" style="width: 370px;"/>
      </el-form-item>
      <el-form-item label="表前缀" >
        <el-input v-model="form.prefix" style="width: 370px;"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="text" @click="cancel">取消</el-button>
      <el-button :loading="loading" type="primary" @click="doSubmit">确认</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { add, edit } from '@/api/oceanGenTest'
export default {
  props: {
    isAdd: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      loading: false, dialog: false,
      form: {
        id: '',
        apiPath: '',
        author: '',
        cover: '',
        moduleName: '',
        pack: '',
        path: '',
        prefix: ''
      },
      rules: {
      }
    }
  },
  methods: {
    cancel() {
      this.resetForm()
    },
    doSubmit() {
      this.loading = true
      if (this.isAdd) {
        this.doAdd()
      } else this.doEdit()
    },
    doAdd() {
      add(this.form).then(res => {
        this.resetForm()
        this.$notify({
          title: '添加成功',
          type: 'success',
          duration: 2500
        })
        this.loading = false
        this.$parent.init()
      }).catch(err => {
        this.loading = false
        console.log(err.response.data.message)
      })
    },
    doEdit() {
      edit(this.form).then(res => {
        this.resetForm()
        this.$notify({
          title: '修改成功',
          type: 'success',
          duration: 2500
        })
        this.loading = false
        this.$parent.init()
      }).catch(err => {
        this.loading = false
        console.log(err.response.data.message)
      })
    },
    resetForm() {
      this.dialog = false
      this.$refs['form'].resetFields()
      this.form = {
        id: '',
        apiPath: '',
        author: '',
        cover: '',
        moduleName: '',
        pack: '',
        path: '',
        prefix: ''
      }
    }
  }
}
</script>

<style scoped>

</style>
