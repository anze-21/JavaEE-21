package com.it.controller;

import com.it.dto.JSONResult;
import com.it.pojo.Task;
import com.it.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Inject
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Task> timeoutTaskList = taskService.findTimeOutTasks();
        model.addAttribute("timeoutTaskList", timeoutTaskList);
        return "task/list";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody
    public List<Task> load(String start, String end) {

        return taskService.findTaskByUserId(start, end);
    }

    /**
     * 新建代办任务
     *
     * @param task
     * @param hour
     * @param min
     * @return
     */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult save(Task task, String hour, String min) {
        taskService.saveTask(task, hour, min);
        return new JSONResult(task);

    }

    /**
     * 删除日程
     *
     * @return
     */
    @RequestMapping(value = "/del/{id:\\d+}", method = RequestMethod.GET)
    @ResponseBody
    public String delTask(@PathVariable Integer id) {
        taskService.delTask(id);
        return "success";
    }

    /**
     * 将日程设置为已完成
     *
     * @return
     */
    @RequestMapping(value = "/{id:\\d+}/done", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult doneTask(@PathVariable Integer id) {
        Task task = taskService.doneTask(id);
        return new JSONResult(task);
    }


}
