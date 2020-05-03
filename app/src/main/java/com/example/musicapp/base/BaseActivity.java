package com.example.musicapp.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 徐国林
 * @data 2020/3/30
 * @decription
 */
public abstract class BaseActivity <T extends BasePresenter> extends AppCompatActivity{
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPresenter = getPresenter();
        if (mPresenter != null)
            mPresenter.addView(this);
    }
    public <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }
    // 设置布局
    protected abstract int setLayout();

    // 初始化组件
    protected abstract void initView();

    // 初始化数据
    protected abstract void initData();


//    //获取当前t的presenter
//    private T getPresenter() {
//        //当前对象的直接超类的 Type
//        Type superclass = getClass().getGenericSuperclass();
//        if (superclass.equals(BaseActivity.class))
//            //参数化类型
//            return null;
//        Type[] arguments = ((ParameterizedType) superclass).getActualTypeArguments();
//        //返回表示此类型实际类型参数的 Type 对象的数组
//        if (arguments.length == 0) {
//            return null;
//        }
//        Class<T> argument = (Class<T>) arguments[0];
//        try {
//            //实例化对象
//            T type = argument.newInstance();
//            return type;
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.destroyView();
    }

}
