package pers.xgd.wxrobot;

import io.github.biezhi.wechat.WeChatBot;
import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;
import io.github.biezhi.wechat.utils.WeChatUtils;

/**
 * Hello world!
 *
 */
public class App  extends WeChatBot 
{
	public App(Config config) {
        super(config);
    }
    
    @Bind(msgType = MsgType.TEXT)
    public void handleText(WeChatMessage message) {
        if (StringUtils.isNotEmpty(message.getName())) {
            //log.info("接收到 [{}] 的消息: {}", message.getName(), message.getText());
            //this.sendMsg(message.getFromUserName(), "自动回复: " + message.getText());
        	System.out.println("---------------------------------------------");
        	String fromUserName = message.getFromUserName();
        	if(fromUserName.contains("@@") && message.getText().equals("测试打印")){ //如果是群聊信息
            	this.api().writeCache();
        	}
        	
        }
    }
    
    public static void main(String[] args) {
        new App(Config.me().autoLogin(false).showTerminal(false)).start();
    }
}
