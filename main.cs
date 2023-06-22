using System.Windows.Forms;

namespace bloxxer
{
    class Program
    {
        static void Main(string[] args)
        {
            Form bloxxer = new Form();
            bloxxer.ShowDialog();
            while (bloxxer.Created)
            {

            }
        }
    }
}