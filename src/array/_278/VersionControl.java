package array._278;

//模拟的类，不是原题的实现
//定死了从第4个版本往后是错误的，只是为了测试跑代码
public class VersionControl {
    boolean isBadVersion(int version){
        if (version>=4){
            return true;
        }
        return false;
    }
}
