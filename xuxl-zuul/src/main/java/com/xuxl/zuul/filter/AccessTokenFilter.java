package com.xuxl.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessTokenFilter extends ZuulFilter {

	// run���������ľ����߼���
	// ͨ��ctx.setSendZuulResponse(false)��zuul���˸����󣬲��������·�ɣ�
	// Ȼ��ͨ��ctx.setResponseStatusCode(401)�������䷵�صĴ����룬
	// Ҳ���Խ�һ���Ż����磬ͨ��ctx.setResponseBody(body)�Է���body���ݽ��б༭��
	public Object run() throws ZuulException {
		
		RequestContext ctx =RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		Object accessToken = request.getParameter("accessToken");
		System.out.println("accessToken:"+accessToken);
		
		if(accessToken == null){
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
		}
		return null;
	}

	// shouldFilter���жϸù������Ƿ���Ҫ��ִ�С�
	// true��ʾ�ù��������������󶼻���Ч��
	// ʵ�����������ǿ������øú�����ָ������������Ч��Χ��
	public boolean shouldFilter() {
		return true;
	}

	// filterOrder����������ִ��˳�򡣵�������һ���׶��д��ڶ��������ʱ����Ҫ���ݸ÷������ص�ֵ������ִ�С�
	@Override
	public int filterOrder() {
		return 0;
	}

	// filterType�������������ͣ���������������������ĸ�����������ִ�С�
	// pre������������·��֮ǰ����
	// route����·������ʱ�򱻵���
	// post����route��error������֮�󱻵���
	// error����������ʱ��������ʱ������
	@Override
	public String filterType() {
		return "pre";
	}

}
