package com.example.musicapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 徐国林
 * @data 2020/3/30
 * @decription
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    protected T mPresenter;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(setLayout(), container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mPresenter = getPresenter();
        if (mPresenter != null) {
            mPresenter.addView(this);
        }
        //???
        if (mPresenter != null) {
            mPresenter.addView(this);
        }
        initView();
        initData();
    }
    // 设置布局
    protected abstract int setLayout();

    // 初始化组件
    protected abstract void initView();

    // 初始化数据
    protected abstract void initData();

//    private T getPresenter() {
//        Type superclass = getClass().getGenericSuperclass();
//        if (superclass.equals(BaseActivity.class))
//            return null;
//        Type[] arguments = ((ParameterizedType) superclass).getActualTypeArguments();
//        if (arguments.length == 0) {
//            return null;
//        }
//        Class<T> argument = (Class<T>) arguments[0];
//        try {
//            //实例化对象
//            T type = argument.newInstance();
//            return type;
//        } catch (java.lang.InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.addView(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.destroyView();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) mPresenter.destroyView();
    }
}
