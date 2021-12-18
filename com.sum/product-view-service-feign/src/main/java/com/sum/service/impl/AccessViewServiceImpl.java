package com.sum.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;
import com.sum.service.AccessViewService;

/**
 * @author summerSmile
 * @date 2021/12/18
 * @apiNote
 */
public class AccessViewServiceImpl implements AccessViewService {
    @Override
    public void accessService() {

    }

    public static void main(String[] args) {
        while(true) {
            ThreadUtil.sleep(1000);
            try {
                String html= HttpUtil.get("http://127.0.0.1:8012/products");
                System.out.println("html length:" + html.length());
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
