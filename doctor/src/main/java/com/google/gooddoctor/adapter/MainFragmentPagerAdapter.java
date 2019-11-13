package com.google.gooddoctor.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import java.util.List;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> a;
    private FragmentManager b;
    private boolean[] c;

    public int getItemPosition(Object obj) {
        return -2;
    }

    public MainFragmentPagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
        this.b = fragmentManager;
        int size = list.size();
        this.c = new boolean[size];
        for (int i = 0; i < size; i++) {
            this.c[i] = false;
        }
    }

    public Fragment getItem(int i) {
        return (Fragment) this.a.get(i);
    }

    public int getCount() {
        return this.a.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        String tag = fragment.getTag();
        if (!this.c[i % this.c.length]) {
            return fragment;
        }
        FragmentTransaction beginTransaction = this.b.beginTransaction();
        beginTransaction.remove(fragment);
        Fragment fragment2 = (Fragment) this.a.get(i % getCount());
        beginTransaction.add(viewGroup.getId(), fragment2, tag);
        beginTransaction.attach(fragment2);
        beginTransaction.commit();
        this.c[i % this.c.length] = false;
        return fragment2;
    }

    public void a(int i, Fragment fragment) {
        this.a.remove(i);
        this.a.add(i, fragment);
        this.c[i] = true;
        notifyDataSetChanged();
    }

    public List<Fragment> a() {
        return this.a;
    }
}