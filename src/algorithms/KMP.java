package algorithms;

/**
 * Created by asus on 2016/11/25.
 */
public class KMP {

    public KMP() {
    }

   public void GetNext (char T[], int next[])   //���ģʽT
                {
                    int i , j ,len ;
                    next[0]= -1 ;
                    for (j= 1; T[j]!='\0';j++)                      //�������next[j]
                    {
                        for (len = j-1;len>=1; len--)
                        {
                            for (i = 0; i < len; i++)
                                if (T[i] != T[j - len + i])
                                    break;
                            if (i == len)
                            {
                                next[j] = len;
                                break;
                            }
                        }

                        if (len < 1)
                            next[j] = 0;
                        //System.out.print( T[j]);
                    }


                }

            public  int KMP(char s[],char t[])
            {
                int i = 0 ,j=0;
                int next[] = new  int[80];
                GetNext(t,next);            //��t��next[]
                while (s[i]!='\0'&&t[j]!='\0')
                {
                    if (s[i]==t[j])
                    {
                        i++;
                        j++;

                    }
                    else
                    {
                        //ƥ��ʧ�ܣ������ƶ�next[j]����λ����ƥ��
                        j=next[j];
                        if (j== -1)
                {
                    i++;
                    j++;
                }
            }
        }
        if (t[j]=='\0')
            return (i-t.length+1);
        else
            return 0;
    }
    protected int[] getNext(char[] p) {
        // ��֪next[j] = k,���õݹ��˼�����next[j+1]��ֵ
        // �����֪next[j] = k,������next[j+1]��?�����㷨����:
        // 1. ���p[j] = p[k], ��next[j+1] = next[k] + 1;
        // 2. ���p[j] != p[k], ����k=next[k],�����ʱp[j]==p[k],��next[j+1]=k+1,
        // ��������,������ݹ�ǰ׺����,�� k=next[k],�����ж�,ֱ��k=-1(��k=next[0])����p[j]=p[k]Ϊֹ
        int pLen = p.length;
        int[] next = new int[pLen];
        int k = -1;
        int j = 0;
        next[0] = -1; // next������next[0]Ϊ-1
        while (j < pLen - 1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


    public int indexOf(String source, String pattern) {
        int i = 0, j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = getNext(ptn);
        while (i < sLen && j < pLen) {
            // ���j = -1,���ߵ�ǰ�ַ�ƥ��ɹ�(src[i] = ptn[j]),����i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // ���j!=-1�ҵ�ǰ�ַ�ƥ��ʧ��,����i����,j=next[j],����patternģʽ������j-next[j]����λ
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        return -1;
    }
}

