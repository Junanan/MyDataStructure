package 递归;
//递归需要遵守的重要规则
//
//执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
//方法的局部变量是独立的，不会相互影响, 比如n变量
//如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
//递归必须向退出递归的条件逼近，否则就是无限递归,出现StackOverflowError，死龟了:)
//当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。


//递归题的三部曲
//①找整个递归的终止条件：递归应该在什么时候结束？
//②找返回值：应该给上一级返回什么信息？
//③本级递归应该做什么：在这一级递归中，应该完成什么任务？

//千万不要去纠结每一级递归的调用和返回细节，因为递归是重复做一件事情

//TreeNode root = new TreeNode(4);
//TreeNode n2 = new TreeNode(2);
//TreeNode n7 = new TreeNode(7);
//TreeNode n1 = new TreeNode(1);
//TreeNode n3 = new TreeNode(3);
//TreeNode n6 = new TreeNode(6);
//TreeNode n9 = new TreeNode(9);
//root.left =n2;
//root.right = n7;
//n2.left =n1;
//n2.right =n3;
//n7.left = n6;
//n7.right = n9;