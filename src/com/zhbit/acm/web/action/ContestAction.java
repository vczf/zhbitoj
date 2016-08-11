package com.zhbit.acm.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.acm.domain.Contest;
import com.zhbit.acm.domain.ContestPlayer;
import com.zhbit.acm.domain.Score;
import com.zhbit.acm.service.ContestPlayerService;
import com.zhbit.acm.service.ContestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cyril on 16/6/19.
 */

@Component(value = "contestAction")
@Scope(value = "prototype")
public class ContestAction extends ActionSupport {

    private int page;

    private int contestId;

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    private ContestService contestService;
    private ContestPlayerService playerService;

    @Resource(name = "contestService")
    public void setContestService(ContestService contestService) {
        this.contestService = contestService;
    }

    @Resource(name = "contestPlayerService")
    public void setPlayerService(ContestPlayerService playerService) {
        this.playerService = playerService;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String list(){
        int count = contestService.getPageCount();
        if (page<=0||page>count)
            page = 1;

        List contests = contestService.ShowContestsByPage(page);

        Map req = (Map) ActionContext.getContext().get("request");
        req.put("contests",contests);

//      把页码摁进去
        req.put("maxPage",count);

//      当前时间,传递过去
        Date current = new Date();
        req.put("current",current);

        return "contest_page";
    }

    public String show(){
        /*
        * register
        watting
        join
        running
        end
        *
        * */

        Contest contest =  contestService.getContestById(contestId);

        if (contest!=null){
            Date current = new Date();
            boolean auth = false;
            Map req = (Map) ActionContext.getContext().get("request");
            Map session = ActionContext.getContext().getSession();
//          判断是否有权限进去比赛
            String userName = (String) session.get("USER_NAME");

            if (userName==null)
                auth = false;
            else if (playerService.exist(userName,contestId))
                auth = true;
            else
                auth = false;



            req.put("contest",contest);
            req.put("current",current);
//          传递权限
            req.put("auth",auth);


            return SUCCESS;
        }
        else
            return "contest_not_found";
    }
    public String ranking(){
        Contest contest = contestService.getContestById(contestId);

        Map<String,Map<Integer,Score>> totalRank = new HashMap<>();

        for (ContestPlayer player:contest.getPlayers()){

        }

        return SUCCESS;
    }

}
