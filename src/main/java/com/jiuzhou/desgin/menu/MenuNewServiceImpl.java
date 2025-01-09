package com.jiuzhou.desgin.menu;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 清洗菜单相关实现类
 */
@Service
public class MenuNewServiceImpl {


    public List<MenuNewDO> executeData() throws Exception {
        // 所有的菜单信息
//        List<MenuNewDO> list = this.list(Wrappers.lambdaQuery());
        List<MenuNewDO> list = new ArrayList<>();
        // 生成 new_id、new_pid 和 new_level
        Map<Long, String> newIdMap = new HashMap<>();
        // 所有 menuId->parentId
        Map<Long, Long> parentIdMap = new HashMap<>();
        // 构建 menuId 到 parentId 的映射
        for (MenuNewDO menu : list) {
            parentIdMap.put(menu.getMenuId(), menu.getParentId());
        }
        
        // 按照父级菜单id进行分组，其下是对应的菜单id集合
        Map<Long, List<MenuNewDO>> groupedByParentId = list.stream()
            .collect(Collectors.groupingBy(MenuNewDO::getParentId));
        
        // 处理根节点（parentId 为 0 的菜单）
        List<MenuNewDO> rootMenus = groupedByParentId.get(0L); // 获取 parentId 为 0 的菜单
        //子一级菜单
        if (rootMenus != null) {
            //循环子一级菜单
            //需要对子一级进行排序
            rootMenus.sort(Comparator.comparingLong(MenuNewDO::getMenuId));
            int index = 0;
            for (MenuNewDO rootMenu : rootMenus) {
                //获取 根菜单
                index++;
                String rootNewId = generateNewId(newIdMap, null, index); // 生成根菜单的 new_id
                rootMenu.setNewId(rootNewId);
                newIdMap.put(rootMenu.getMenuId(), rootNewId);
                rootMenu.setNewLevel(1); // 根菜单的层级为 1
            }
        }
        //初始化得到处理后的一级节点 加入队列
        Queue<MenuNewDO> queue = new LinkedList<>(rootMenus);

        while (!queue.isEmpty()) {
            //假设此处是队首出列
            MenuNewDO currentMenu = queue.poll();
            Long currentMenuId = currentMenu.getMenuId();

            // 获取当前菜单的子菜单
            List<MenuNewDO> children = groupedByParentId.get(currentMenuId);
            if (children != null) {
                // 按 menuId 排序子菜单，确保最小的 menuId 在前
                children.sort(Comparator.comparingLong(MenuNewDO::getMenuId));
                
                for (int i = 0; i < children.size(); i++) {
                    MenuNewDO childMenu = children.get(i);
                    String newId = generateNewId(newIdMap, currentMenuId, i+1); // 生成 new_id
                    childMenu.setNewId(newId);
                    newIdMap.put(childMenu.getMenuId(), newId);
                    
                    // 设置 new_pid
                    childMenu.setNewPid(generateNewPid(newIdMap.get(currentMenuId))); // 确保 parentId 的长度为 20 位
                    
                    // 设置 new_level
                    childMenu.setNewLevel(getNewLevel(newIdMap, childMenu.getMenuId(), parentIdMap)); // 直接调用 getNewLevel
                    
                    // 将子菜单加入队列
                    queue.add(childMenu);
                }
            }
        }
        
        return list;
    }

    private String generateNewId(Map<Long, String> newIdMap, Long parentId, int index) {

        StringBuilder newId = new StringBuilder();
        // 根节点的处理
        if (parentId == null) {
            newId.append("12").append(String.format("%018d", 0)); // 顶层菜单，填充到 20 位
        } else {
            // 获取父级的 new_id
            String parentNewId = newIdMap.get(parentId);
            if (parentNewId == null) {
                throw new IllegalArgumentException("Parent newId not found for parentId: " + parentId);
            }
            // 获取父级id parentId = 12030000000000000000， int index 如果等于3 则 menuId = 12030300000000000000
            String replace = trimTrailingZeros(parentNewId);

            newId.append(replace);  
            if(index<10){
                newId.append("0").append(index);
            }else{
                newId.append(index);
            }
            // 填充到 20 位
            while (newId.length() < 20) {
                newId.append("0");
            }
        }

        return newId.toString();
    }

    private String generateNewPid(String parentNewId) {
        // 确保 parentId 的长度为 20 位
        StringBuilder newPid = new StringBuilder(parentNewId);
        
        // 填充到 20 位
        while (newPid.length() < 20) {
            newPid.append("0");
        }
        
        return newPid.toString();
    }

    private int getNewLevel(Map<Long, String> newIdMap, Long menuId, Map<Long, Long> parentIdMap) {
        // 根据 menuId 获取对应的 new_level
        String currentNewId = newIdMap.get(menuId);
        if (currentNewId == null) {
            return 0; // 如果没有找到当前菜单，返回 0
        }

        // 计算当前层级
        int level = 0;
        Long parentId = parentIdMap.get(menuId); // 从 parentIdMap 获取 parentId

        while (parentId != null) {
            level++;
            parentId = parentIdMap.get(parentId); // 继续查找父级
        }

        return level; // 返回基于根节点的层级
    }

    private String trimTrailingZeros(String id) {
        // 从后面去除所有的0
        int index = id.length() - 1;
        while (index >= 0 && id.charAt(index) == '0') {
            index--;
        }
        // 返回去除后的字符串
        String result = id.substring(0, index + 1);
        
        // 如果结果的长度是单数，则在末尾补零
        if (result.length() % 2 != 0) {
            result += "0";
        }
        
        return result;
    }
}
